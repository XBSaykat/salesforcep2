package net.maxproit.salesforce.masum.fragment.prospect.prospectstage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.feature.upload.UploadActivity;
import net.maxproit.salesforce.feature.upload.UploadProspectActivity;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.AttachmentDbController;
import net.maxproit.salesforce.masum.model.local.Attachment;
import net.maxproit.salesforce.masum.model.local.MyNewProspect;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.masum.utility.ImageUtils;

import java.io.IOException;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PropectStageAttachmentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PropectStageAttachmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PropectStageAttachmentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button btnDoc;
    public static ImageView imgAtach, imgIdCard, imgVisitingCard;
    private Button btnImgCap, btnIDCardCap, btnVCardCap, btnChoosePP, btnChooseId, btnChooseVCard;
    private OnFragmentInteractionListener mListener;
    private TextView tvID, tvPhoto, tvVCard;
    private Uri filePathUri = null;
    AttachmentDbController attachmentDbController;
    ArrayList<Attachment> attachmentArrayList;
    public static Bitmap attachPp=null,attachIdcard=null,attachvCard=null;
    public PropectStageAttachmentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PropectStageAttachmentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PropectStageAttachmentFragment newInstance(String param1, String param2) {
        PropectStageAttachmentFragment fragment = new PropectStageAttachmentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e("crash","attach");
        View rootView = inflater.inflate(R.layout.fragment_lead_stage_attachment, container, false);

        initView(rootView);
        initListener();
        initIntentData();
        return rootView;
    }


    private void initView(View rootView) {
        imgAtach = rootView.findViewById(R.id.img_atach_pp);
        imgIdCard = rootView.findViewById(R.id.img_atach_id_card);
        imgVisitingCard = rootView.findViewById(R.id.img_atach_v_card);
        btnDoc=rootView.findViewById(R.id.btn_doc);
        btnImgCap = rootView.findViewById(R.id.btn_capture_pp);
        btnIDCardCap = rootView.findViewById(R.id.btn_atach_id);
        btnVCardCap = rootView.findViewById(R.id.btn_atach_v_card);
        btnChoosePP = rootView.findViewById(R.id.btn_choose_pp);
        btnChooseId = rootView.findViewById(R.id.btn_choose_id);
        btnChooseVCard = rootView.findViewById(R.id.btn_choose_v_card);
        tvID = rootView.findViewById(R.id.tv_id_text);
        tvPhoto = rootView.findViewById(R.id.tv_photo_text);
        tvVCard = rootView.findViewById(R.id.tv_v_text);
    }

    private void initListener() {
        btnDoc.setOnClickListener(view->{
            ActivityUtils.getInstance().invokeActivity(getActivity(),UploadProspectActivity.class,false);
        });
        btnImgCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //takePicture.setType("image/*");
                if (takePicture.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(takePicture, AppConstant.REQUEST_IMAGE_CAPTURE);

                }
            }
        });

        btnIDCardCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //takePicture.setType("image/*");
                if (takePicture.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(takePicture, AppConstant.REQUEST_ID_CARD_CAPTURE);

                }
            }
        });

        btnVCardCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //takePicture.setType("image/*");
                if (takePicture.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(takePicture, AppConstant.REQUEST_VCARD_CAPTURE);
                }
            }
        });

        btnChoosePP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creating intent.
                Intent intent = new Intent();
                // Setting intent type as image to select image from phone storage.
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, AppConstant.SELECT_IMAGE_TITLE), AppConstant.REQUEST_IMAGE_CHOOSE);
            }
        });

        btnChooseId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                // Setting intent type as image to select image from phone storage.
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, AppConstant.SELECT_IMAGE_TITLE), AppConstant.REQUEST_ID_CARD_CHOOSE);
            }
        });

        btnChooseVCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                // Setting intent type as image to select image from phone storage.
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, AppConstant.SELECT_IMAGE_TITLE), AppConstant.REQUEST_VCARD_CHOOSE);
            }
        });

    }

    private void initIntentData() {
        if (getArguments() != null) {
            int status = getArguments().getInt(AppConstant.STATUS_INTENT_KEY);
            if (status == 1) {
                MyNewProspect myNewLead = (MyNewProspect) getArguments().getSerializable(AppConstant.INTENT_KEY);
                if (myNewLead != null) {

                    initAttachMentData(myNewLead);

                }
            }

        }
    }

    private void initAttachMentData(MyNewProspect myNewLead) {
        attachmentDbController = new AttachmentDbController(getActivity());
        if (attachmentDbController.getAllData
                (String.valueOf(myNewLead.getId())).size() > 0) {
            attachmentArrayList = new ArrayList<>();
            attachmentArrayList.addAll(attachmentDbController.getAllData(String.valueOf(myNewLead.getId())));
            tvPhoto.setVisibility(View.GONE);
            tvID.setVisibility(View.GONE);
            tvVCard.setVisibility(View.GONE);
            imgAtach.setVisibility(View.VISIBLE);
            imgIdCard.setVisibility(View.VISIBLE);
            imgVisitingCard.setVisibility(View.VISIBLE);

            imgAtach.setImageBitmap(ImageUtils.getBitmapFromByte(attachmentArrayList.get(0).getProfilePic()));
            imgIdCard.setImageBitmap(ImageUtils.getBitmapFromByte(attachmentArrayList.get(0).getIdCard()));
            imgVisitingCard.setImageBitmap(ImageUtils.getBitmapFromByte(attachmentArrayList.get(0).getVisitingCard()));
        }

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AppConstant.REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
            attachPp  = (Bitmap) extras.get("data");
            imgAtach.setImageBitmap(attachPp);

            imgAtach.setVisibility(View.VISIBLE);
            tvPhoto.setVisibility(View.GONE);

        } else if (requestCode == AppConstant.REQUEST_ID_CARD_CAPTURE && resultCode == RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
             attachIdcard = (Bitmap) extras.get("data");
            imgIdCard.setImageBitmap(attachIdcard);

            imgIdCard.setVisibility(View.VISIBLE);
            tvID.setVisibility(View.GONE);


        } else if (requestCode == AppConstant.REQUEST_VCARD_CAPTURE && resultCode == RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
             attachvCard = (Bitmap) extras.get("data");
            imgVisitingCard.setImageBitmap(attachvCard);

            imgVisitingCard.setVisibility(View.VISIBLE);
            tvVCard.setVisibility(View.GONE);

        } else if (requestCode == AppConstant.REQUEST_IMAGE_CHOOSE && resultCode ==
                RESULT_OK && data != null && data.getData() != null) {
            filePathUri = data.getData();

            try {

                // Getting selected image into Bitmap.
               attachPp = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), filePathUri);
                // Setting up bitmap selected image into ImageView.
                Glide.with(getActivity()).load(filePathUri).into(imgAtach);
                //imgAtach.setImageBitmap(bitmap);
                if (data.getData() != null) {
                    imgAtach.setVisibility(View.VISIBLE);
                    tvPhoto.setVisibility(View.GONE);
                }

            } catch (IOException e) {

                e.printStackTrace();
            }
        } else if (requestCode == AppConstant.REQUEST_ID_CARD_CHOOSE && resultCode ==
                RESULT_OK && data != null && data.getData() != null) {
            filePathUri = data.getData();

            try {

                // Getting selected image into Bitmap.
                attachIdcard = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), filePathUri);
                // Setting up bitmap selected image into ImageView.
                Glide.with(getActivity()).load(filePathUri).into(imgIdCard);

                //imgIdCard.setImageBitmap(bitmap);
                if (data.getData() != null) {
                    imgIdCard.setVisibility(View.VISIBLE);
                    tvID.setVisibility(View.GONE);
                }


            } catch (IOException e) {

                e.printStackTrace();
            }
        } else if (requestCode == AppConstant.REQUEST_VCARD_CHOOSE && resultCode ==
                RESULT_OK && data != null && data.getData() != null) {
            filePathUri = data.getData();

            try {

                // Getting selected image into Bitmap.
                attachvCard = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), filePathUri);
                Glide.with(getActivity()).load(filePathUri).into(imgVisitingCard);
                // Setting up bitmap selected image into ImageView.
                //imgVisitingCard.setImageBitmap(bitmap);
                if (data.getData() != null) {
                    imgVisitingCard.setVisibility(View.VISIBLE);
                    tvVCard.setVisibility(View.GONE);
                }

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
