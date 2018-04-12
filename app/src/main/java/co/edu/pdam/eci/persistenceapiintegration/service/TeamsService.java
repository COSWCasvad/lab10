package co.edu.pdam.eci.persistenceapiintegration.service;

import java.util.List;

import co.edu.pdam.eci.persistenceapiintegration.data.entity.Team;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by carlos.sanchez-v on 4/11/2018.
 */

public interface TeamsService {
    @GET( "teams.json" )
    Call<List<Team>> getTeamsList( );
}
