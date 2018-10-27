package findandfix.utils;

/**
 * Created by DELL on 04/03/2018.
 */

public class ConfigurationFile {

    public static class SharedPrefConstants{
        public static final String SHARED_PREF_NAME="FIND_AND_FIX_WORKSHOP";
        public static final String PREF_CAR_OWNER_OBJ_DATA ="CAR_OWNER_DATA";
        public static final String DARK_MODE_PARAM ="DARK_MODE";
        public static final String APP_LANGUAGE ="APP_LANGUAGE";
        public static final String FIRST_TIME ="is_first_time";
        public static final String PREF_REQUEST_OBJECT ="REQUEST_OBJECT";}


    public static class IntentsConstants{
        public static final String VIDEO_URL="video_url";
        public static final String CAR_OWNER_REGISTER_REQUEST_OBJ="REGISTER_REQUEST";
        public static final String CAR_OWNER_ADV_OBJ="ADV_OBJ";
        public static final String CAR_OWNER_ADD_REQUEST_OBJ="add_normal_request_obj";
        public static final String CAR_OWNER_ADD_URGENT_REQUEST_OBJ="add_normal_request_obj";
        public static final String WORKSHOP_OFFER_OBJ="workshop_offer_obj";
        public static final String WORKSHOP_OFFERS="workshop_offers";
        public static final String REQUESt_DETAIL_OBJ="request_details";
        public static final String USER_CODE="user_code";
        public static final String WORKSHOP_URGENT_OFFERS="workshop_urgent_offers";
        public static final String WORKSHOP_URGENT_OFFER="workshop_urgent_offer";
        public static final String URGENT_REQUESt_DETAIL_OBJ="urgent_request_details";
        public static final String WORKSHOP_ID="workshop_id";
        public static final String WORKSHOP_NAME="workshop_name";
        public static final String REQUEST_ID="request_id";
        public static final String DEVICE_TOKEN="device_token";
        public static final String URGENT_REQUEST_ID="urgent_request_id";
        public static final String NORMAL_REQUEST_ID="normal_request_id";
        public static final String WORKING_DAYS_TAG="WORKING_DAYS";
        public static final String WORKSHOP_PROFILE_IMAGES_TAG="WORKSHOP_PROFILE_IMAGES_TAG";
        public static final String WENSH_TYPES="WENSH_TYPES";
        public static final String SPECIALIZATION_TYPES="SPECIALIZATION_TYPES";
    }
    public static class UrlConstants{
        public static final String BASE_URL="http://new.findandfix.com/api/";
        public static final String LOGIN ="carowner/login";
        public static final String REGISTER="carowner/register";
        public static final String COUNTRIES="countries";
        public static final String CITIES="cities/{country_id}";
        public static final String BRANDS="brands";
        public static final String MODELS="models/{brand_id}";
        public static final String CHECK_EMAIL_URL="carowner/check/email";
        public static final String CHECK_MOBILE_URL="carowner/check/mobile";
        public static final String ACTIVATE_CAR_OWNER_URL="carowner/activate";
        public static final String ACTIVATE_CAR_OWNER_UPDATE_PROFILE="carowner/profile";
        public static final String CHANGE_PASSWORD_URL="carowner/change-password";
        public static final String GET_OFFERS_URL="carowner/ads";
        public static final String ADD_GARAGE_URL="carowner/garage";
        public static final String GET_SPECIALIZATION="specializations";
        public static final String GET_SUB_SPECIALIZATIONS="specializations/{parent_id}";
        public static final String ADD_NORMAL_REQUEST="carowner/normal-request";
        public static final String GET_REQUEST_OFFERS_URL="carowner/normal-request/offers/{normal-request-id}";
        public static final String GET_URGENT_REQUEST_OFFERS_URL="carowner/active-urgent-request/offers";
        public static final String ACCEPT_WORKSHOP_OFFERS_URL="carowner/normal-request/accept/{offerID}";
        public static final String ACCEPT_URGENT_WORKSHOP_OFFERS_URL="carowner/urgent-request/accept/{offerID}";
        public static final String GET_CAR_OWNER_ACTIVE_REQUESTS_URL="carowner/normal-request/active";
        public static final String GET_CAR_OWNER_ACTIVE_URGENT_REQUESTS_URL="carowner/urgent-request/active";
        public static final String GET_WORKSHOP_ACHIEVMENTS_URL="carowner/get-achivements/{workshopId}";
        public static final String ADD_WORKSHOP_RATE_URL="carowner/ratings";
        public static final String ADD_URGENT_REQUEST_URL="carowner/urgent-request";
        public static final String CAR_OWNER_LOGOUT_URL="carowner/logout";
        public static final String GET_REST_TOKEN_URL="carowner/get-reset-token";
        public static final String HAS_REST_TOKEN_URL="carowner/check-reset-token";
        public static final String RESET_PASSWORD_URL="carowner/reset-password";
        public static final String SEND_NOTIFICATION_URL="send-notification";
        public static final String WENSH_TYPES_URL="winch-types";
        public static final String CANCEL_URGENT_REQUEST_URL="carowner/urgent-request/{urgent_request_id}";
        public static final String CANCEL_NORMAL_REQUEST_URL="carowner/normal-request/{normal_request_id}";
        public static final String MY_ORDERS_URL="carowner/normal-request/completed";
        public static final String SEND_ACTIVATION_CODE_URL="carowner/activate/phone/send";
        public static final String CHECK_ACTIVATION_CODE_URL="carowner/activate/phone";
        public static final String CHECK_ACTIVATION_MAIL_URL="carowner/activate/email/send";
        public static final String FIND_WORKSHOPS_URL="carowner/workshops/closest";
    }



        public static class Constants{
            public static final String REQUEST_TYPE ="REQUEST_TYPE";
            public static final int   CUSTOM_KEY=-1;
            public static final int NO_DATA=511;
            public static final int   USER_ACTIVATED=1;
            public static final int   PLACE_PICKER_REQUEST=1;
            public static final int CHOOSE_BRANDS=2;
            public static  final int CHOOSE_COUNTRY=4;
            public static  final int CHOOSE_IMAGE_FROM_GALLERY=5;
            public static final int SUCCESS_CODE =200;
            public static final int SUCCESS_REGISTRATION =201;
            public static final int SUCCESS_GARAGE =201;
            public static final int  NORMAL_REQUEST_ADDED_SUCCESSFULLY=201;
            public static final int EMPTY_VALUE=-1;
            public static final int CANT_COMPLETE_REQUEST_CODE =403;
            public static final int UNCONFIRMED_CODE =417;
            public static final int INVALID_USERNAME_PASSWORD_LOGIN_CODE=401;
            public static final int UNUTHENTICATED_CODE=401;
            public static final int UNUTHENTICATED=471;
            public static final int INVALID_DATA =422;
            public static final int FILL_ALL_DATTA=216;
            public static final int MOVE_TO_REGISTER_ACTIVITY=3;
            public static final int  MINIMUM_PASSWORD_LENGTH=8;
            public static final int SHOW_DIALOG_CODE=468;
            public static final int CAMERA_REQUEST=202;
            public static final int GALLERY_REQUEST=203;
            public static final int PERMISSION_DENIED =-203;
            public static final int PERMISSION_GRANTED_CAMERA =204;
            public static final int PERMISSION_GRANTED_GALLERY =205;
            public static final int PERMISSION_GRANTED_VIDEO =501;
            public static final int PERMISSION_GRANTED_RECORD_AUDIO=513;
            public static final int PERMISSION_DENIED_RECORD_AUDIO=-210;
            public static final int HANDLE_FIND_REQUESTS_TOOLBAR =502;
            public static final int HANDLE_WORKSHOP_OFFERS_TOOLBAR =503;
            public static final int HANDLE_WORKSHOP_ACHIEVMENTS_TOOLBAR =504;
            public static final int HANDLE_WORKSHOP_URGENT_REQUEST_TOOLBAR =505;
            public static final int HANDLE_NORMAL_REQUEST_SECONDARY_TOOLBAR =506;
            public static final int HANDLE_REQUEST_DETAIL_TOOLBAR =507;
            public static final int HANDLE_WORKSHOP_URGENT_REQUEST_SECONDARY_TOOLBAR =508;
            public static final int HANDLE_WORKSHOP_URGENT_REQUEST_OFFERS=509;
            public static final int HANDLE_WORKSHOP_URGENT_REQUEST_DETAIL_TOOLBAR =510;
            public static final int MOVE_APP_INTRO_ACT =512;
            public static final int HANDLE_APP_RATE =511;
            public static final int PERMISSION_GRANTED_LOCATION =500;
            public static final int PERMISSION_GRANTED_PHONE_CALL =500;
            public static final int PERMISSION_DENIED_PHONE_CALL =-203;
            public static final int UNEXPECTED_ERROR =500;
            public static final String API_KEY="d7VJ5M5X9emP8ZXvmALlPryAwIJMXmRtO9WxdDj55ypFPgn3JCfTqM3CaEsD";
            public static final String Content_Type="application/json";
            public static final int NO_INTERNET_CONNECTION_CODE =-206;
            public static final String APP_LANGUAGE ="";
            public static final int SPLASH_TIME_OUT=5000;
            public static final int MOVE_TO_MAIN_ACT=430;
            public static final int MOVE_TO_LOGIN_ACT=413;
            public static final int COMPLETE_ANIMATION_CODE=436;
            public static final int NORMAL_REQUEST_ACTIVITY=437;
            public static final int URGENT_REQUEST_ACTIVITY=438;
            public static final int EDIT_PROFILE_ACTIVITY=439;
            public static final int ADVERTISEMENT_ACTIVITY=440;
            public static final int CLOSE_MENU_DRAWER=448;
            public static final int MOVE_TO_MAIN_FRAG=454;
            public static final int MOVE_TO_SETTING_FRAG=456;
            public static final int HANDLE_MAIN_TOOLBAR=457;
            public static final int HANDLE_NORMAL_REQUEST_TOOLBAR =458;
            public static final int HANDLE_URGENT_REQUEST_TOOLBAR =459;
            public static final int HANDLE_EDIT_PROFILE_TOOLBAR =460;
            public static final int HANDLE_ADD_ADVERTISING_TOOLBAR =461;
            public static final int HANDLE_CONVERSATION_HISTORY_TOOLBAR =462;
            public static final int HANDLE_CHANGE_PASSWORD_TOOLBAR =463;
            public static final int HANDLE_NORMAL_REQUEST_DETAIL_TOOLBAR =464;
            public static final int HANDLE_CUSTOM_ADD_ADVERTISING_TOOLBAR =465;
            public static final int MOVE_TO_ABOUT_FRAG=468;
            public static final int MY_ORDERS=520;
            public static final int CHANGE_PASSWORD_ACT=449;
            public static final int MOVE_TO_ACTIVATION_FRAG=469;
            public static final int DATA_ISNT_MATCH=470;
            public static final int INVALID_PASSWORD_CONFIRMATION=451;
            public static final int INVALID_PASSWORD_FORMAT=457;
            public static final int HANDLE_ADVERTISING_DETAIL_TOOLBAR=471;
            public static final int HANDLE_ACTIVATION_CODE_TOOLBAR=521;
            public static final int NEAREST_WORKSHOP_CODE=522;
            public static final int SHOW_SERVICE_TYPE_CODE=523;
            public static final int HANDLE_FILTER_TOOLBAR =524;
            public static final int REQUEST_CODE =525;
            public static final int EMPTY_SPECIALIZATION =526;

        }

    public static class PermissionsClass {
        public static final String WRITE_EXTERNAL_STORAGE =android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
        public static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE = 101;
    }
}
