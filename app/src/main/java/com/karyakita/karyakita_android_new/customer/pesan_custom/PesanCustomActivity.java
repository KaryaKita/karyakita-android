package com.karyakita.karyakita_android_new.customer.pesan_custom;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import butterknife.BindView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.data_pengiriman.DataPengirimanCustomerActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class PesanCustomActivity extends AppCompatActivity implements IPesanCustomView {
    EditText date;
    DatePickerDialog datePickerDialog;
    PesanCustomPresenter pesanCustomPresenter;
    private Button btn;
    private ImageView imageview;
    private static final String IMAGE_DIRECTORY = "/demonuts";
    Realm realm;
    PesanCustomRealmHelper pesanCustomRealmHelper;
    PesanCustomModelRealm pesanCustomModelRealm;
    Spinner spinner;


    @BindView(R.id.iv_img_custom) ImageView img_custom;
    @BindView(R.id.sp_pilih_kategori) Spinner pilih_kategori;
    @BindView(R.id.sp_pilih_ukuran) Spinner ukuran_kertas;
    @BindView(R.id.date) EditText ed_date;
    @BindView(R.id.sp_pilih_bingkai) Spinner pilih_bingkai;
    @BindView(R.id.ed_catatan) EditText ed_catatan;
    @BindView(R.id.btnLanjut) Button btnLanjut;

    MultipartBody.Part fileToUpload;

    String ukuran, calender, catatan, image;
    Integer kategori,opsi_bingkai;
    private int GALLERY = 1, CAMERA = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_custom);
        ButterKnife.bind(this);
        Realm.init(PesanCustomActivity.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().schemaVersion(3)
                .deleteRealmIfMigrationNeeded().build();
        realm = Realm.getInstance(configuration);

        img_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPictureDialog();
            }
        });

        date = (EditText) findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(PesanCustomActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(year + "-"
                                        + (monthOfYear + 1) + "-" + dayOfMonth);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kategori = 1;

                image    = img_custom.toString();
                opsi_bingkai = 1;
                ukuran   = ukuran_kertas.getSelectedItem().toString();
                calender = date.toString();
                catatan  = ed_catatan.getText().toString();


                ukuran = ukuran_kertas.getSelectedItem().toString();
                catatan = ed_catatan.getText().toString();
                image = img_custom.toString();

                if (!kategori.equals("") && !ukuran.equals("") && !catatan.equals(("")) && !image.equals((""))) {
                    pesanCustomModelRealm = new PesanCustomModelRealm();
                    pesanCustomModelRealm.setKategori_karya_id(kategori);
                    pesanCustomModelRealm.setUkuran(ukuran);
                    pesanCustomModelRealm.setTanggal_deadline(calender);
                    pesanCustomModelRealm.setOpsi_order_id(opsi_bingkai);
                    pesanCustomModelRealm.setCatatan(catatan);
                    pesanCustomModelRealm.setGambar(image);

                    pesanCustomRealmHelper = new PesanCustomRealmHelper(realm);
                    pesanCustomRealmHelper.save(pesanCustomModelRealm);

                    Log.d("TAG", "sukses masuk dong");

                    setupPresenter(fileToUpload);
                }
                else {
                    Toast.makeText(getApplicationContext(), "isidong", Toast.LENGTH_LONG);
                }
            }
        });
    }

    private void showPictureDialog() {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select photo from gallery",
                "Capture photo from camera"};
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    private void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    String path = saveImage(bitmap);
                    Toast.makeText(PesanCustomActivity.this, "Image Saved!", Toast.LENGTH_SHORT).show();
                    img_custom.setImageBitmap(bitmap);

                    String filePath = getRealPathFromURIPath(contentURI, PesanCustomActivity.this);
                    Log.wtf("TAG ", "File path = " + filePath);
                    File file = new File(filePath);

                    RequestBody mFile = RequestBody.create(MediaType.parse("image/*"), file);
                    fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), mFile);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(PesanCustomActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == CAMERA) {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            img_custom.setImageBitmap(thumbnail);
            saveImage(thumbnail);
            Toast.makeText(PesanCustomActivity.this, "Image Saved!", Toast.LENGTH_SHORT).show();
        }
    }

    private String getRealPathFromURIPath(Uri contentURI, Activity activity) {
        Cursor cursor = activity.getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) {
            return contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(idx);
        }
    }

    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }

        try {
            File f = new File(wallpaperDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(this,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();
            Log.d("TAG", "File Saved::--->" + f.getAbsolutePath());

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }


    private void setupPresenter( MultipartBody.Part file){
        Map<String, String> inputan = new HashMap<String, String>();
        inputan.put("pilih_kategori", pilih_kategori.toString());
        inputan.put("ukuran_kertas", ukuran_kertas.toString());
        inputan.put("calender", ed_date.toString());
        inputan.put("opsi", pilih_bingkai.toString());
        inputan.put("catatan", catatan.toString());
//        inputan.put("gambar", img_custom.toString());
        pesanCustomPresenter.setImagePesanCustom(this.fileToUpload);
        pesanCustomPresenter = new PesanCustomPresenter(this);
        pesanCustomPresenter.insert(inputan);

    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(PesanCustomResultModel model) {
        if (model != null)
            startActivity(new Intent(PesanCustomActivity.this, DataPengirimanCustomerActivity.class));
    }

    @Override
    public void displayError(String s) {

    }
}
