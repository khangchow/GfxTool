package com.testapp.ramboostergfxtool.fragment;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.Fragment;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.google.android.material.imageview.ShapeableImageView;
import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.crosshair.common.Const;
import com.testapp.ramboostergfxtool.crosshair.customview.DialogList;
import com.testapp.ramboostergfxtool.crosshair.interfaces.ItemListDialogClick;
import com.testapp.ramboostergfxtool.crosshair.service.CrossHairService;
import com.testapp.ramboostergfxtool.crosshair.utils.NotificationUtils;
import com.testapp.ramboostergfxtool.crosshair.utils.SharePreferenceUtils;

import java.util.List;

public class CrossHairFragment extends Fragment {
    private static final int REQUEST_CODE_PERMISSION_OVERLAY = 100;
    private ImageView btnResetSize;
    private Button btnResetX;
    private Button btnResetY;
    private int colorSelected;
    private int crossHair;
    private EditText edtStep;
    private ImageButton imgArrowDown;
    private ImageButton imgArrowLeft;
    private ImageButton imgArrowRight;
    private ImageButton imgArrowUp;
    private ImageView imgCrossHair;
    private List<Integer> listCrossHair;
    private ShareActionProvider mShareActionProvider;
    private NotificationUtils notificationUtils;
    private int opacity = 100;
    private int posX = 0;
    private int posY = 0;
    private SeekBar sbOpacity;
    private SeekBar sbSize;
    private SharePreferenceUtils sharePreferenceUtils;
    private int size = 100;
    private Button startAction;
    private int step = 10;
    private TextView tvHorizontalValue;
    private TextView tvOpacity;
    private TextView tvSize;
    private TextView tvVerticalValue;
    private ShapeableImageView vColor;
    private int value = 0;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_crosshair, viewGroup, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(getContext())) {
            this.startAction.setText(getResources().getString(R.string.start));
        } else if (!isMyServiceRunning(CrossHairService.class)) {
            this.startAction.setText(getResources().getString(R.string.start));
        } else {
            this.startAction.setText(getResources().getString(R.string.stop));
        }
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.sharePreferenceUtils = new SharePreferenceUtils(getContext());
        this.notificationUtils = new NotificationUtils(getContext());
        this.listCrossHair = Const.createListCrossHair();
        initUI(view);
    }
    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= 23 && !isSystemAlertPermissionGranted(getContext())) {

            final Dialog dialog = new Dialog(getActivity());
            dialog.setContentView(R.layout.dialog_ask_crosshair);
            final Button dialogButton = (Button) dialog.findViewById(R.id.btnClos);
            final Button btnAllow = (Button) dialog.findViewById(R.id.btnAllow);
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();

                }

            });
            btnAllow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    CrossHairFragment.requestSystemAlertPermission(CrossHairFragment.this.getActivity(), 100);
                }
            });

            dialog.show();
        }
    }


    private void initUI(View view) {
        this.startAction = (Button) view.findViewById(R.id.action_start);
        this.vColor = view.findViewById(R.id.vColor);
        this.imgCrossHair = (ImageView) view.findViewById(R.id.imgCrossHair);
        this.tvSize = (TextView) view.findViewById(R.id.tvSize);
        this.sbSize = (SeekBar) view.findViewById(R.id.sbSize);
        this.tvOpacity = (TextView) view.findViewById(R.id.tvOpacity);
        this.sbOpacity = (SeekBar) view.findViewById(R.id.sbOpacity);
        this.imgArrowLeft = (ImageButton) view.findViewById(R.id.imgArrowLeft);
        this.imgArrowRight = (ImageButton) view.findViewById(R.id.imgArrowRight);
        this.imgArrowUp = (ImageButton) view.findViewById(R.id.imgArrowUp);
        this.imgArrowDown = (ImageButton) view.findViewById(R.id.imgArrowDown);
        this.btnResetSize = (ImageView) view.findViewById(R.id.btnResetSize);
        this.tvHorizontalValue = (TextView) view.findViewById(R.id.tvHorizontalValue);
        this.tvVerticalValue = (TextView) view.findViewById(R.id.tvVerticalValue);
        this.btnResetX = (Button) view.findViewById(R.id.btnResetX);
        this.btnResetY = (Button) view.findViewById(R.id.btnResetY);
        this.edtStep = (EditText) view.findViewById(R.id.edtStep);
        this.crossHair = this.sharePreferenceUtils.getIntValue(Const.KEY_SHARE_CROSS_HAIR, R.drawable.ic_chr_01);
        this.colorSelected = this.sharePreferenceUtils.getIntValue(Const.KEY_SHARE_COLOR, SupportMenu.CATEGORY_MASK);
        this.posX = this.sharePreferenceUtils.getIntValue(Const.KEY_SHARE_POSITION_X, 0);
        this.posY = this.sharePreferenceUtils.getIntValue(Const.KEY_SHARE_POSITION_Y, 0);
        this.size = this.sharePreferenceUtils.getIntValue(Const.KEY_SHARE_SIZE, 100);
        this.opacity = this.sharePreferenceUtils.getIntValue(Const.KEY_SHARE_OPCACITY, 100);

        this.vColor.setBackgroundColor(this.colorSelected);
        this.imgCrossHair.setImageResource(this.crossHair);
        this.tvHorizontalValue.setText(String.valueOf(this.posX));
        this.tvVerticalValue.setText(String.valueOf(this.posY));
        final TextView textView = this.tvSize;
        final TextView textView2 = this.tvOpacity;
        textView.setText(this.size + "%");
        textView2.setText(this.opacity + "%");
        this.sbSize.setProgress(this.size);
        this.sbOpacity.setProgress(this.opacity);
        this.startAction.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = 23)
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(CrossHairFragment.this.getContext())) {
                    CrossHairFragment.this.checkPermission();
                }

                 else if (!CrossHairFragment.this.isMyServiceRunning(CrossHairService.class)) {
                    Intent intent = new Intent(CrossHairFragment.this.getContext(), CrossHairService.class);
                    intent.setAction(Const.KEY_ACTION_IS_SHOW);
                    CrossHairFragment.this.getActivity().startService(intent);
                    CrossHairFragment.this.startAction.setText(CrossHairFragment.this.getResources().getString(R.string.stop));
                } else {
                    CrossHairFragment.this.getActivity().stopService(new Intent(CrossHairFragment.this.getContext(), CrossHairService.class));
                    CrossHairFragment.this.startAction.setText(CrossHairFragment.this.getResources().getString(R.string.start));
                }
            }
        });
        this.vColor.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = 23)
            public void onClick(View view) {
                CrossHairFragment.this.onCrossHairViewClick(view);
            }
        });
        this.imgCrossHair.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = 23)
            public void onClick(View view) {
                CrossHairFragment.this.onCrossHairViewClick(view);
            }
        });
        this.imgArrowLeft.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = 23)
            public void onClick(View view) {
                CrossHairFragment.this.onCrossHairViewClick(view);
            }
        });
        this.imgArrowRight.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = 23)
            public void onClick(View view) {
                CrossHairFragment.this.onCrossHairViewClick(view);
            }
        });
        this.imgArrowUp.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = 23)
            public void onClick(View view) {
                CrossHairFragment.this.onCrossHairViewClick(view);
            }
        });
        this.imgArrowDown.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = 23)
            public void onClick(View view) {
                CrossHairFragment.this.onCrossHairViewClick(view);
            }
        });
        this.btnResetY.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = 23)
            public void onClick(View view) {
                CrossHairFragment.this.onCrossHairViewClick(view);
            }
        });
        this.btnResetX.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = 23)
            public void onClick(View view) {
                CrossHairFragment.this.onCrossHairViewClick(view);
            }
        });
        this.btnResetSize.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = 23)
            public void onClick(View view) {
                CrossHairFragment.this.onCrossHairViewClick(view);
            }
        });
        this.sbSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                textView.setText(i + "%");
                CrossHairFragment.this.sharePreferenceUtils.setIntValue(Const.KEY_SHARE_SIZE, i);
                CrossHairFragment.this.updateCrossHairService();
            }
        });
        this.sbOpacity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                textView2.setText(i + "%");
                CrossHairFragment.this.sharePreferenceUtils.setIntValue(Const.KEY_SHARE_OPCACITY, i);
                CrossHairFragment.this.updateCrossHairService();
            }
        });
    }

    public static void requestSystemAlertPermission(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            String packageName = activity.getPackageName();
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + packageName));
            if (activity != null) {
                activity.startActivityForResult(intent, i);
            } else {
                activity.startActivityForResult(intent, i);
            }
        }
    }

    @TargetApi(23)
    public static boolean isSystemAlertPermissionGranted(Context context) {
        return Build.VERSION.SDK_INT < 21 || Settings.canDrawOverlays(context);
    }
    private boolean isMyServiceRunning(Class<?> cls) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE)).getRunningServices(Integer.MAX_VALUE)) {
            if (cls.getName().equals(runningServiceInfo.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public void onCrossHairViewClick(View view) {
        try {
            int id = view.getId();
            if (id != R.id.vColor) {
                switch (id) {
                    case R.id.btnResetSize :
                        this.tvSize.setText("100%");
                        this.sbSize.setProgress(100);
                        this.sharePreferenceUtils.setIntValue(Const.KEY_SHARE_SIZE, 100);
                        updateCrossHairService();
                        return;
                    case R.id.btnResetX :
                        this.tvHorizontalValue.setText(String.valueOf(0));
                        this.sharePreferenceUtils.setIntValue(Const.KEY_SHARE_POSITION_X, 0);
                        updateCrossHairService();
                        return;
                    case R.id.btnResetY :
                        this.tvVerticalValue.setText(String.valueOf(0));
                        this.sharePreferenceUtils.setIntValue(Const.KEY_SHARE_POSITION_Y, 0);
                        updateCrossHairService();
                        return;
                    default:
                        switch (id) {
                            case R.id.imgArrowDown :
                                if (this.edtStep.getText() == null) {
                                    return;
                                }
                                if (this.edtStep.getText().length() != 0) {
                                    this.step = Integer.valueOf(this.edtStep.getText().toString()).intValue();
                                    this.value = Integer.valueOf(this.tvVerticalValue.getText().toString()).intValue();
                                    this.posY = this.value - this.step;
                                    this.tvVerticalValue.setText(String.valueOf(this.posY));
                                    this.sharePreferenceUtils.setIntValue(Const.KEY_SHARE_POSITION_Y, this.posY);
                                    updateCrossHairService();
                                    return;
                                }
                                return;
                            case R.id.imgArrowLeft :
                                if (this.edtStep.getText() == null) {
                                    return;
                                }
                                if (this.edtStep.getText().length() != 0) {
                                    this.step = Integer.valueOf(this.edtStep.getText().toString()).intValue();
                                    this.value = Integer.valueOf(this.tvHorizontalValue.getText().toString()).intValue();
                                    this.posX = this.value - this.step;
                                    this.tvHorizontalValue.setText(String.valueOf(this.posX));
                                    this.sharePreferenceUtils.setIntValue(Const.KEY_SHARE_POSITION_X, this.posX);
                                    updateCrossHairService();
                                    return;
                                }
                                return;
                            case R.id.imgArrowRight :
                                if (this.edtStep.getText() == null) {
                                    return;
                                }
                                if (this.edtStep.getText().length() != 0) {
                                    this.step = Integer.valueOf(this.edtStep.getText().toString()).intValue();
                                    this.value = Integer.valueOf(this.tvHorizontalValue.getText().toString()).intValue();
                                    this.posX = this.value + this.step;
                                    this.tvHorizontalValue.setText(String.valueOf(this.posX));
                                    this.sharePreferenceUtils.setIntValue(Const.KEY_SHARE_POSITION_X, this.posX);
                                    updateCrossHairService();
                                    return;
                                }
                                return;
                            case R.id.imgArrowUp :
                                if (this.edtStep.getText() == null) {
                                    return;
                                }
                                if (this.edtStep.getText().length() != 0) {
                                    this.step = Integer.valueOf(this.edtStep.getText().toString()).intValue();
                                    this.value = Integer.valueOf(this.tvVerticalValue.getText().toString()).intValue();
                                    this.posY = this.value + this.step;
                                    this.tvVerticalValue.setText(String.valueOf(this.posY));
                                    this.sharePreferenceUtils.setIntValue(Const.KEY_SHARE_POSITION_Y, this.posY);
                                    updateCrossHairService();
                                    return;
                                }
                                return;
                            case R.id.imgCrossHair :
                                new DialogList(getContext(), this.listCrossHair, new ItemListDialogClick() {

                                    @Override
                                    public void onItemClick(int i) {
                                        CrossHairFragment.this.imgCrossHair.setImageResource(((Integer) CrossHairFragment.this.listCrossHair.get(i)).intValue());
                                        CrossHairFragment.this.sharePreferenceUtils.setIntValue(Const.KEY_SHARE_CROSS_HAIR, ((Integer) CrossHairFragment.this.listCrossHair.get(i)).intValue());
                                        CrossHairFragment.this.updateCrossHairService();
                                    }
                                }).show();
                                return;
                            default:
                                return;
                        }
                }
            } else {
                showDialogChooseColor(this.colorSelected);
            }
        } catch (Exception unused) {
        }
    }

    private void showDialogChooseColor(int i) {
        ColorPickerDialogBuilder.with(getContext(), R.style.DialogColor).setTitle(getResources().getString(R.string.choose_color)).initialColor(i).wheelType(ColorPickerView.WHEEL_TYPE.FLOWER).density(12).setPositiveButton(getResources().getString(R.string.ok), new ColorPickerClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i, Integer[] numArr) {
                CrossHairFragment.this.colorSelected = i;
                CrossHairFragment.this.vColor.setBackgroundColor(i);
                CrossHairFragment.this.sharePreferenceUtils.setIntValue(Const.KEY_SHARE_COLOR, i);
                CrossHairFragment.this.updateCrossHairService();
            }
        }).setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).build().show();
    }
    private void updateCrossHairService() {
        if (isMyServiceRunning(CrossHairService.class)) {
            Intent intent = new Intent(getContext(), CrossHairService.class);
            intent.setAction(Const.KEY_ACTION_IS_UPDATE);
            getActivity().startService(intent);
        }
    }


}
