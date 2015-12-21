package com.aethernadev.ormlitedomain.databasehelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import javax.inject.Inject;

import com.aethernadev.ormlitedomain.product.OLProduct;

/**
 * Created by Aetherna on 2015-11-17.
 */
public class OrmLiteDatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "OLDatabase";
    public static final int DATABASE_VERSION = 1;
    public static final String LOG_TAG = "OrmLite DB";

    @Inject
    public OrmLiteDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, OLProduct.class);
        } catch (SQLException e) {
            Log.e(LOG_TAG, "Failed to create database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    public Dao<OLProduct, Integer> getProductDao() {
        try {
            return getDao(OLProduct.class);
        } catch (SQLException e) {
            Log.e(LOG_TAG, "Exception creating Dao: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
