/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */
package longhoang.com.comicbase.data.remote;

import longhoang.com.comicbase.BuildConfig;

public final class BAnkApiEndPoint {
    public static final String ENDPOINT_BLOG = BuildConfig.BASE_URL + "/5926ce9d11000096006ccb30";
    public static final String ENDPOINT_HOME = BuildConfig.BASE_URL + "/home";
    public static final String ENDPOINT_DETAIL_COMIC = BuildConfig.BASE_URL + "/detailComic";
    public static final String ENDPOINT_CHAPTER = BuildConfig.BASE_URL + "/chapter";
    public static final String ENDPOINT_CATEGORY = BuildConfig.BASE_URL + "/categoryComic";
    public static final String ENDPOINT_CATEGORY_CONTENT = BuildConfig.BASE_URL +
        "/contentCategory";

    private BAnkApiEndPoint() {
        // This class is not publicly instantiable
    }
}
