/*
 * Copyright (C) 2018 AlexMofer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package am.project.x.business.developing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.io.File;
import java.util.List;

import am.project.support.font.truetype.TrueTypeFullNameUtils;
import am.project.x.R;
import am.project.x.base.BaseActivity;

/**
 * 正在开发
 */
public class DevelopingActivity extends BaseActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, DevelopingActivity.class));
    }

    @Override
    protected int getContentViewLayout() {
        return R.layout.activity_developing;
    }

    @Override
    protected void initializeActivity(@Nullable Bundle savedInstanceState) {
        setSupportActionBar(R.id.developing_toolbar);
//        final TypefaceConfig config = TypefaceConfig.getInstance();
//        if (config.isAvailable()) {
//            final List<String> names = config.getNames();
//            for (String name : names) {
//                System.out.println("lallalalalla-----------------------------name:" + name);
//            }
//            final TypefaceCollection collection = config.getTypefaceCollection("sans-serif");
//            if (collection != null) {
//                Log.d("MainActivity", collection.toString());
//                final List<TypefaceItem> items = collection.getItems();
//                for (TypefaceItem item : items) {
//                    System.out.println("lallalalalla-----------------------------items name:" + item.getName());
//                }
//                final List<TypefaceFallback> fallbacks = collection.getFallbacks();
//                for (TypefaceFallback fallback : fallbacks) {
//                    System.out.println("lallalalalla----------------------------------------------fallback lang:" + fallback.getLang());
//                    final List<TypefaceItem> its = fallback.getItems();
//                    for (TypefaceItem item : its) {
//                        System.out.println("lallalalalla-----------------------------fallback items name:" + item.getName());
//                    }
//                }
//            }
//        }

        final File dir = new File("/system/fonts");
        if (dir.exists() && dir.isDirectory()) {
            // list
            final File[] fonts = dir.listFiles();
            if (fonts != null) {
                for (File font : fonts) {
                    List<String> names;
                    try {
                        names = TrueTypeFullNameUtils.getFullNames(font);
                    } catch (Exception e) {
                        names = null;
                    }
                    if (names != null) {
                        for (String name : names) {
                            System.out.println("lalalalal-----------------------------------------font:" + name);
                        }
                    }
                }
            }
        }
        finish();
    }
}
