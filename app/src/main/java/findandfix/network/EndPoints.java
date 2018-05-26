package findandfix.network;


import findandfix.model.request.LoginRequest;
import findandfix.model.request.RegisterRequest;
import findandfix.model.response.BrandsResponse;
import findandfix.model.response.CitiesResponse;
import findandfix.model.response.CountriesResponse;
import findandfix.model.response.LoginResponse;


import findandfix.model.response.ModelsResponse;
import findandfix.model.response.RegisterResponse;
import findandfix.utils.ConfigurationFile;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EndPoints {
    @POST(ConfigurationFile.UrlConstants.LOGIN)
    Observable<Response<LoginResponse>> login(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Body LoginRequest loginRequest);


    @POST(ConfigurationFile.UrlConstants.LOGIN)
    Observable<Response<RegisterResponse>> register(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Body RegisterRequest registerRequest);


    @GET(ConfigurationFile.UrlConstants.COUNTRIES)
    Observable<Response<CountriesResponse>> getCountries(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept);

    @GET(ConfigurationFile.UrlConstants.CITIES)
    Observable<Response<CitiesResponse>> getCities(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Path("country_id") int Cid);

    @GET(ConfigurationFile.UrlConstants.BRANDS)
    Observable<Response<BrandsResponse>> getBrands(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept);

    @GET(ConfigurationFile.UrlConstants.MODELS)
    Observable<Response<ModelsResponse>> getModels(@Header("x-api-key") String key, @Header("Accept-Language") String lang, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Path("brand_id") int Cid);


}
