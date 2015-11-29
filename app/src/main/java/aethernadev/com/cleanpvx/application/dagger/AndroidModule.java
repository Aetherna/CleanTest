package aethernadev.com.cleanpvx.application.dagger;

import com.aethernadev.component.ProductPresenter;

import aethernadev.com.cleanpvx.component.ProductComponent;
import aethernadev.com.cleanpvx.component.ProductComponentAdapter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Aetherna on 2015-11-22.
 */
@Module
public class AndroidModule {

    @Provides
    ProductComponent provideProductComponent(ProductPresenter productPresenter, ProductComponentAdapter lookupsAdapter) {
        return new ProductComponent(productPresenter, lookupsAdapter);
    }

    @Provides
    ProductComponentAdapter provideProductComponentAdapter(){
        return new ProductComponentAdapter();
    }

}
