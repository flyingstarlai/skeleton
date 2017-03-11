package starlai.dev.skeleton.data.remote;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by izayoi on 11/22/2016.
 */

public interface ApiService {
    @GET("TSU/Server.aspx")
    Observable<Response<ResponseBody>> insertQR(@Query("QRS") String qrdata);
}
