package hua.tung.smk.pandaspbt.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;

import java.util.List;

import hua.tung.smk.pandaspbt.R;
import hua.tung.smk.pandaspbt.databinding.ActivityScanBinding;

public class ScanActivity extends AppCompatActivity {

    private ActivityScanBinding scanBinding;
    private String lastText;

    private BarcodeCallback callback = new BarcodeCallback() {
        @Override
        public void barcodeResult(BarcodeResult result) {
            if(result.getText() == null || result.getText().equals(lastText)) {
                // Prevent duplicate scans
                return;
            }

            lastText = result.getText();
            scanBinding.barcodeScanner.setStatusText(result.getText());
//            beepManager.playBeepSoundAndVibrate();

            //Added preview of scanned barcode
//            ImageView imageView = (ImageView) findViewById(R.id.barcodePreview);
//            imageView.setImageBitmap(result.getBitmapWithResultPoints(Color.YELLOW));
        }

        @Override
        public void possibleResultPoints(List<ResultPoint> resultPoints) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_scan);

        scanBinding = DataBindingUtil.setContentView(this, R.layout.activity_scan);
        scanBinding.barcodeScanner.decodeContinuous(callback);
    }

    @Override
    protected void onResume() {
        super.onResume();
        scanBinding.barcodeScanner.resume();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return scanBinding.barcodeScanner.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }
}
