package findandfix.network;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import findandfix.model.global.CheckActivationCodeRequest;
import findandfix.model.global.MsgRequest;
import findandfix.model.global.SendActivationCodeRequest;
import findandfix.model.global.UrgentRequest;
import findandfix.model.request.AcceptedOfferNotification;
import findandfix.model.request.AddGarageRequest;
import findandfix.model.request.AddNormalRequest;
import findandfix.model.request.ChangePasswordRequest;
import findandfix.model.request.CheckCode;
import findandfix.model.request.EmailRequest;
import findandfix.model.request.ForgetPasswordRequest;
import findandfix.model.request.GetMobileCode;
import findandfix.model.request.LoginRequest;
import findandfix.model.request.MobileRequest;
import findandfix.model.request.RateRequest;
import findandfix.model.request.RegisterRequest;
import findandfix.model.request.UpdateProfileRequest;
import findandfix.model.response.AchievmentResponse;
import findandfix.model.response.ActiveNormalRequestResponse;
import findandfix.model.response.ActiveUrgentRequestResponse;
import findandfix.model.response.AddGarageResponse;
import findandfix.model.response.AddUrgentRequestResponse;
import findandfix.model.response.BrandsResponse;
import findandfix.model.response.CitiesResponse;
import findandfix.model.response.CountriesResponse;
import findandfix.model.response.DefaultResponse;
import findandfix.model.response.LoginRegisterResponse;
import findandfix.model.response.ModelsResponse;
import findandfix.model.response.OffersResponse;
import findandfix.model.response.RequestOfferResponse;
import findandfix.model.response.SpecializationResponse;
import findandfix.model.response.UrgentRequestOfferResponse;
import findandfix.model.response.WinshResponse;
import findandfix.model.response.WorkShopRequestResponse;
import findandfix.model.response.WorkshopSearchResponse;
import findandfix.utils.ConfigurationFile;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EndPoints {
    @POST(ConfigurationFile.UrlConstants.LOGIN)
    Observable<Response<LoginRegisterResponse>> login(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Body LoginRequest loginRequest);


    @POST(ConfigurationFile.UrlConstants.REGISTER)
    Observable<Response<LoginRegisterResponse>> register(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Body RegisterRequest registerRequest);


    @GET(ConfigurationFile.UrlConstants.COUNTRIES)
    Observable<Response<CountriesResponse>> getCountries(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept);

    @GET(ConfigurationFile.UrlConstants.CITIES)
    Observable<Response<CitiesResponse>> getCities(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Path("country_id") int Cid);

    @GET(ConfigurationFile.UrlConstants.BRANDS)
    Observable<Response<BrandsResponse>> getBrands(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept);

    @GET(ConfigurationFile.UrlConstants.MODELS)
    Observable<Response<ModelsResponse>> getModels(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Path("brand_id") int Cid);

    @POST(ConfigurationFile.UrlConstants.CHECK_EMAIL_URL)
    Observable<Response<Integer>> checkEmail(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Body EmailRequest emailRequest);


    @POST(ConfigurationFile.UrlConstants.CHECK_MOBILE_URL)
    Observable<Response<Integer>> checkMobile(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Body MobileRequest mobileRequest);

    @GET(ConfigurationFile.UrlConstants.ACTIVATE_CAR_OWNER_URL)
    Observable<Response<Integer>> checkUserActivation(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String token);


    @PUT(ConfigurationFile.UrlConstants.ACTIVATE_CAR_OWNER_UPDATE_PROFILE)
    Observable<Response<DefaultResponse>> editProfile(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String token,@Body UpdateProfileRequest updateProfileRequest);


    @PUT(ConfigurationFile.UrlConstants.CHANGE_PASSWORD_URL)
    Observable<Response<DefaultResponse>> changePasswordApi(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String auth,@Body ChangePasswordRequest changePasswordRequest);


    @GET(ConfigurationFile.UrlConstants.GET_OFFERS_URL)
    Observable<Response<OffersResponse>> getOffers(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String auth,@Query("page") int pageId);

    @POST(ConfigurationFile.UrlConstants.ADD_GARAGE_URL)
    Observable<Response<AddGarageResponse>> addGarage(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String auth, @Body AddGarageRequest addGarageRequest);

    @GET(ConfigurationFile.UrlConstants.GET_SPECIALIZATION)
    Observable<Response<SpecializationResponse>> getSpecializations(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept);


    @GET(ConfigurationFile.UrlConstants.GET_SUB_SPECIALIZATIONS)
    Observable<Response<SpecializationResponse>> getSubSpecializations(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Path("parent_id") int Cid);

    @POST(ConfigurationFile.UrlConstants.ADD_NORMAL_REQUEST)
    Observable<Response<AddUrgentRequestResponse>> addNormalRequest(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept,@Header("Authorization") String auth,@Body AddNormalRequest addNormalRequest);

    @GET(ConfigurationFile.UrlConstants.GET_REQUEST_OFFERS_URL)
    Observable<Response<RequestOfferResponse>> getRequestOffers(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String auth, @Path("normal-request-id") int Cid);

    @POST(ConfigurationFile.UrlConstants.ACCEPT_WORKSHOP_OFFERS_URL)
    Observable<Response<DefaultResponse>> acceptWorkShopOffer(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String auth, @Body AcceptedOfferNotification acceptedOfferNotification, @Path("offerID") int Cid);

    @GET(ConfigurationFile.UrlConstants.GET_CAR_OWNER_ACTIVE_REQUESTS_URL)
    Observable<Response<ActiveNormalRequestResponse>> getCarOwnerActiveRequests(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String auth);

    @GET(ConfigurationFile.UrlConstants.GET_WORKSHOP_ACHIEVMENTS_URL)
    Observable<Response<AchievmentResponse>> getAchievments(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String autht,@Path("workshopId") int wid, @Query("page") int pageId);

    @POST(ConfigurationFile.UrlConstants.ADD_WORKSHOP_RATE_URL)
    Observable<Response<DefaultResponse>> acceptWorkShopRate(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String auth, @Body RateRequest rateRequest);


    @POST(ConfigurationFile.UrlConstants.ADD_URGENT_REQUEST_URL)
    Observable<Response<AddUrgentRequestResponse>> addUrgentRequest(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String auth, @Body  Map<String, Object> fields);
// Observable<Response<DefaultResponse>> addUrgentRequest(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String auth, @Body UrgentRequest urgentRequest);

    @GET(ConfigurationFile.UrlConstants.GET_CAR_OWNER_ACTIVE_URGENT_REQUESTS_URL)
    Observable<Response<ActiveUrgentRequestResponse>> getCarOwnerActiveUrgentRequest(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String auth);


    @GET(ConfigurationFile.UrlConstants.GET_URGENT_REQUEST_OFFERS_URL)
    Observable<Response<UrgentRequestOfferResponse>> getUrgentRequestOffers(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String auth);


    @POST(ConfigurationFile.UrlConstants.ACCEPT_URGENT_WORKSHOP_OFFERS_URL)
    Observable<Response<DefaultResponse>> acceptUrgentWorkShopOffer(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String auth,@Body AcceptedOfferNotification acceptedOfferNotification, @Path("offerID") int Cid);


    @GET(ConfigurationFile.UrlConstants.CAR_OWNER_LOGOUT_URL)
    Observable<Response<DefaultResponse>> logout(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String auth);

    @POST(ConfigurationFile.UrlConstants.GET_REST_TOKEN_URL)
    Observable<Response<DefaultResponse>> getRestToken(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Body GetMobileCode getMobileCode);


    @POST(ConfigurationFile.UrlConstants.HAS_REST_TOKEN_URL)
    Observable<Response<Integer>> hasRestToken(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Body CheckCode checkCode);


    @POST(ConfigurationFile.UrlConstants.RESET_PASSWORD_URL)
    Observable<Response<DefaultResponse>> resetPassword(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Body ForgetPasswordRequest forgetPasswordRequest);



    @POST(ConfigurationFile.UrlConstants.SEND_NOTIFICATION_URL)
    Observable<Response<DefaultResponse>> sendNotification(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Body MsgRequest messageNotification);


    @GET(ConfigurationFile.UrlConstants.WENSH_TYPES_URL)
    Observable<Response<WinshResponse>> getWinchTypes(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept);


    @DELETE(ConfigurationFile.UrlConstants.CANCEL_URGENT_REQUEST_URL)
    Observable<Response<DefaultResponse>> cancelUrgentRequest(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept,@Header("Authorization") String auth,@Path("urgent_request_id") int Cid);

    @DELETE(ConfigurationFile.UrlConstants.CANCEL_NORMAL_REQUEST_URL)
    Observable<Response<DefaultResponse>> cancelNormalRequest(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept,@Header("Authorization") String auth,@Path("normal_request_id") int Cid);

    @GET(ConfigurationFile.UrlConstants.CANCEL_NORMAL_REQUEST_URL)
    Observable<Response<DefaultResponse>> myOrders(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept,@Header("Authorization") String auth);


    @GET(ConfigurationFile.UrlConstants.MY_ORDERS_URL)
    Observable<Response<WorkShopRequestResponse>> getCompletedRequests(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String auth,@Query("page") int pageId);

    @POST(ConfigurationFile.UrlConstants.SEND_ACTIVATION_CODE_URL)
    Observable<Response<DefaultResponse>> sendActivationCode(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String auth, @Body SendActivationCodeRequest sendActivationCodeRequest);

    @POST(ConfigurationFile.UrlConstants.CHECK_ACTIVATION_CODE_URL)
    Observable<Response<DefaultResponse>> checkActivationCode(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String auth, @Body CheckActivationCodeRequest checkActivationCodeRequest);

    @GET(ConfigurationFile.UrlConstants.FIND_WORKSHOPS_URL)
    Observable<Response<WorkshopSearchResponse>> findNearestWorkshop(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String auth, @Query("lat") double lat,
                                                                     @Query("lng") double lng, @Query("winch_types[]") ArrayList<Integer> winch_types, @Query("specializations[]") ArrayList<Integer> specializations);



    @POST(ConfigurationFile.UrlConstants.CHECK_ACTIVATION_MAIL_URL)
    Observable<Response<DefaultResponse>> sendActivationMail(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Header("Authorization") String auth);
}
