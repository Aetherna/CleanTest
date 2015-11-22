package aethernadev.com.ormlitedomain.module;

import android.content.Context;

import aethernadev.com.ormlitedomain.databasehelper.OrmLiteDatabaseHelper;
import dagger.Module;
import dagger.Provides;

/**
 * Created by IT on 2015-11-17.
 */
@Module
public class OrmLiteDbHelperModule {

    //    protected OpenHelperManager openHelperManager;
    private Context context;

    public OrmLiteDbHelperModule(Context context) {
        this.context = context;
//        this.openHelperManager = new OpenHelperManager();
//        OrmLiteDatabaseHelper opDatabaseHelper = new OrmLiteDatabaseHelper(context);
//        this.openHelperManager.setHelper(opDatabaseHelper);
    }

    @Provides
    OrmLiteDatabaseHelper provideOrmLiteDatabaseHelper() {
//        return openHelperManager.getHelper(context, OrmLiteDatabaseHelper.class);
        return new OrmLiteDatabaseHelper(context);
    }
}
