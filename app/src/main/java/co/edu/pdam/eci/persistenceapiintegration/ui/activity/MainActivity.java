package co.edu.pdam.eci.persistenceapiintegration.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import co.edu.pdam.eci.persistenceapiintegration.R;
import co.edu.pdam.eci.persistenceapiintegration.data.DBException;
import co.edu.pdam.eci.persistenceapiintegration.data.OrmModel;
import co.edu.pdam.eci.persistenceapiintegration.data.dao.TeamDao;
import co.edu.pdam.eci.persistenceapiintegration.data.entity.Team;
import co.edu.pdam.eci.persistenceapiintegration.network.NetworkException;
import co.edu.pdam.eci.persistenceapiintegration.network.RequestCallback;
import co.edu.pdam.eci.persistenceapiintegration.network.RetrofitNetwork;

public class MainActivity
    extends AppCompatActivity
{

    private OrmModel ormModel;
    private RetrofitNetwork retrofitNetwork;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ormModel = new OrmModel();
        ormModel.init(this);
        final TeamDao teamDao = ormModel.getTeamDao();
        /*
        try {
            teamDao.create(new Team("name1","shortName1","imageUrl1"));
            teamDao.create(new Team("name2","shortName2","imageUrl2"));
            teamDao.create(new Team("name3","shortName3","imageUrl3"));
            teamDao.create(new Team("name4","shortName4","imageUrl4"));
        } catch (DBException e) {
            e.printStackTrace();
        }*/
        ExecutorService executorService = Executors.newFixedThreadPool( 1 );

        executorService.execute( new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    //Network request code goes here
                    retrofitNetwork = new RetrofitNetwork();
                    retrofitNetwork.getTeams(new RequestCallback<List<Team>>() {
                        @Override
                        public void onSuccess(List<Team> response) {
                            for(Team t:response){
                                try {
                                    teamDao.create(t);
                                } catch (DBException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void onFailed(NetworkException e) {
                            e.printStackTrace();
                        }
                    });
                }
                catch ( Exception e )
                {
                    e.printStackTrace();
                }
            }
        } );

        try {
            for(Team t:teamDao.getAll()){
                System.out.println("---------------------------------------");
                System.out.println(t);
            }
        } catch (DBException e) {
            e.printStackTrace();
        }






    }
}
