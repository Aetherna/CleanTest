package aethernadev.com.ormlitedomain.module;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import javax.inject.Singleton;

import aethernadev.com.ormlitedomain.databasehelper.OrmLiteDatabaseHelper;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Aetherna on 2015-11-17.
 */
@Module
public class OrmLiteDbHelperModule {

    private Context context;

    public OrmLiteDbHelperModule(Context context) {
        this.context = context;
        OrmLiteDatabaseHelper opDatabaseHelper = new OrmLiteDatabaseHelper(context);
        OpenHelperManager.setHelper(opDatabaseHelper);
    }

    @Singleton
    @Provides
    OrmLiteDatabaseHelper provideOrmLiteDatabaseHelper() {
        return OpenHelperManager.getHelper(context, OrmLiteDatabaseHelper.class);
    }

}
