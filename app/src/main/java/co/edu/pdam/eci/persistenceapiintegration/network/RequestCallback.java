package co.edu.pdam.eci.persistenceapiintegration.network;

/**
 * Created by carlos.sanchez-v on 4/11/2018.
 */

public interface RequestCallback<T> {
    void onSuccess( T response );

    void onFailed( NetworkException e );
}
