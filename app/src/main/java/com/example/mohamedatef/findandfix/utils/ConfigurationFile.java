package com.example.mohamedatef.findandfix.utils;

/**
 * Created by DELL on 04/03/2018.
 */

public class ConfigurationFile {

    public static class SharedPrefConstants{
        public static final String SHARED_PREF_NAME="FIND_AND_FIX_WORKSHOP";
        public static final String PREF_WORKSHOP_DATA="WORKSHOP_DATA";
        public static final String PREF_REGISTER_OBJECT ="FIRST_STEP";
        public static final String PREF_REQUEST_OBJECT ="REQUEST_OBJECT";
        public static final String PREF_COUNTRIES_OBJECT ="COUNTRIES_OBJECT";
        public static final String PREF_CITIES_OBJECT ="CITIES_OBJECT";
        public static final String PREF_BRANDS_OBJECT ="BRANDS_OBJECT";
        public static final String PREF_SPECIALIZATIONS_OBJECT ="SPECIALIZATION_OBJECT";
        public static final String PREF_URGNENTS_OBJECT ="URGENTS_OBJECT";
    }

    public static class UrlConstants{
        public static final String BASE_URL="http://new.findandfix.com/";
        public static final String LOGIN_URL="api/workshop/login";
        public static final String REGISTER_URL="api/workshop/register";
        public static final String COUNTRIES_URL="api/countries";
        public static final String CITIES_URL="api/cities/{country_id}";
        public static final String BRANDS_URL="api/brands";
        public static final String MODELS_URL="api/models/{brand_id}";
        public static final String SPECIALIZE_URL="api/specializations";
        public static final String CHECK_EMAIL_URL="api/workshop/check/email";
        public static final String CHECK_MOBILE_URL="api/workshop/check/mobile";
        public static final String URGENT_REQUEST_TYPES_URL="api/urgent-request-types";
        public static final String WORKSHOP_NORMAL_REQUESTS_URL="api/workshop/normal-requests";
        public static final String WORKSHOP_PENDING_REQUESTS_URL="api/workshop/normal-requests/status/pending";
        public static final String WORKSHOP_IN_PROGRESS_REQUESTS_URL="api/workshop/normal-requests/status/in-progress";
        public static final String WORKSHOP_COMPLETED_REQUESTS_URL="api/workshop/normal-requests/status/completed";
        public static final String GET_WORKSHOP_OFFERS_URL="api/workshop/offers/{requestID}";
        public static final String COMPLETE_WORKSHOP_REQUEST_URL="api/workshop/offers/complete-fixing/{offerID}";
        public static final String ADD_WORKSHOP_OFFER_URL="api/workshop/offers/{requestID}";
        public static final String UPDATE_DELETE_WORKSHOP_OFFER_URL="api/workshop/offers/{offerID}";
        public static final String UPDATE_WORKSHOP_PROFILE_URL="api/workshop/profile";
        public static final String SUBSCRIBED_URL="api/workshop/subscribe";
    }



        public static class Constants{
        public static final int SUCCESS_CODE =200;
        public static final int SUCCESS_REGISTER_CODE =201;
        public static final int OFFER_ADDED_SUCCESSFULLY =201;
        public static final int UNAUTHENTICATED_CODE =401;
        public static final String REQUEST_TYPE ="REQUEST_TYPE";
        public static final int PUBLISH_REQUEST_DETAIL =214;
        public static final int OFFERED_REQUEST_DETAIL =215;
        public static final int UNSUBSCRIBED_CODE =401;
        public static final int CUSTOM_ERROR_CODE =-202;
        public static final int CANT_COMPLETE_REQUEST_CODE =403;
        public static final int INVALID_USERNAME_PASSWORD_LOGIN_CODE=401;
        public static final int INVALID_DATA =422;
        public static final int INVALID_LOCATION_CODE=1;
        public static final int FILL_ALL_DATTA=216;
        public static final int INVALID_CITY_CODE=2;
        public static final int INVALID_COUNTRY_CODE=3;
        public static final int DISPLAY_SPECIALIZATION_DIALOG=431;
        public static final int DISPLAY_URGENT_TYPES_DIALOG=432;
        public static final int DISPLAY_SPECIALIZATION_DIALOG_TEXT=433;
        public static final int DISPLAY_URGENT_TYPES_DIALOG_text=434;
        public static final int UPDATE_BRANDS_DIALOG=435;
        public static final int CANCEL_DIALOG_DATA=4;
        public static final int SUBMIT_DIALOG_DATA=5;
        public static final int EMPTY_PROVIDER_TYPE=1;
        public static final int EMPTY_WORKSHOP_SPECIALIZATION=2;
        public static final int EMPTY_WORKSHOP_BRANDS=3;
        public static final int EMPTY_WORKSHOP_URGENT_TYPES=4;
        public static final int MOVE_TO_NEXT_ACTIVITY=1;
        public static final int MOVE_TO_PREVIOUS_ACTIVITY=2;
        public static final int MOVE_TO_REGISTER_ACTIVITY=3;
        public static final int FROM=1;
        public static final int To=2;
        public static final int SHOW_DIALOG_CODE=201;
        public static final int SHOW_BRANDS_DIALOG_CODE=416;
        public static final int SHOW_SPECIALIZE_DIALOG_CODE=417;
        public static final int SHOW_URGENTS_DIALOG_CODE=418;
        public static final int SHOW_CITIES_DIALOG_CODE=414;
        public static final int CAMERA_REQUEST=202;
        public static final int GALLERY_REQUEST=203;
        public static final int PERMISSION_DENIED =-203;
        public static final int PERMISSION_GRANTED_CAMERA =204;
        public static final int PERMISSION_GRANTED_GALLERY =205;
        public static final int CHOOSE_IMAGE_FROM_GALLERY =-205;
        public static final String API_KEY="d7VJ5M5X9emP8ZXvmALlPryAwIJMXmRtO9WxdDj55ypFPgn3JCfTqM3CaEsD";
        public static final String Content_Type="application/json";
        public static final int NO_INTERNET_CONNECTION_CODE =-206;
        public static final int EMPTY_OFFER_DESCRIBTION_CODE =-210;
        public static final int EMPTY_OFFER_PRICE_CODE =-211;
        public static final int EMPTY_OFFER_DATE_CODE=-212;
        public static final int SPLASH_TIME_OUT=5000;
        public static final int MOVE_TO_MAIN_ACT=430;
        public static final int MOVE_TO_LOGIN_ACT=413;
        public static final int SELECT_COUNTRY_CODE=415;
        public static final int COMPLETE_ANIMATION_CODE=436;
        public static final int NORMAL_REQUEST_ACTIVITY=437;
        public static final int URGENT_REQUEST_ACTIVITY=438;
        public static final int EDIT_PROFILE_ACTIVITY=439;
        public static final int ADD_ADVERTISEMENT_ACTIVITY=440;
        public static final int MOVET_TO_NEXT_TAB=441;
        public static final int INVALID_EMAIL_FORMAT=442;
        public static final int MOVE_TO_SUBSCRIBTION_ACTIVITY=443;
        public static final int TIME_ERROR=444;
        public static final int CLOSE_CURRENT_ACTIVITY=445;
        }

    public static class PermissionsClass {
        public static final String WRITE_EXTERNAL_STORAGE =android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
        public static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE =101;
    }
}
