package aethernadev.com.realmdomain.product.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by IT on 2015-11-04.
 */
@Module
public class RealmModule {

    Context context;

    public RealmModule(Context context) {
        this.context = context;
    }

    @Provides
    Realm provideRealm() {
        return Realm.getInstance(context);
    }

}
