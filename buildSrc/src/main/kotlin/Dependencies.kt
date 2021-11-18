object Dependencies {
    private const val composeVersion = "1.1.0-beta03"
    private const val apolloVersion = "2.5.11"
    private const val coilVersion = "1.4.0"

    const val composeUIToolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    const val composeUI = "androidx.compose.ui:ui:$composeVersion"

    const val coreKtx = "androidx.core:core-ktx:1.7.0"
    const val appCompat = "androidx.appcompat:appcompat:1.4.0"
    const val androidMaterial = "com.google.android.material:material:1.4.0"
    const val material3 = "androidx.compose.material3:material3:1.0.0-alpha01"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0"
    const val activityCompose = "androidx.activity:activity-compose:1.4.0"
    const val composeNavigation = "androidx.navigation:navigation-compose:2.4.0-beta02"

    const val googlePlayAuthServices = "com.google.android.gms:play-services-auth:19.2.0"
    const val firebaseBom = "com.google.firebase:firebase-bom:29.0.0"
    const val firebaseAuth = "com.google.firebase:firebase-auth-ktx"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
    const val firebasePerformance = "com.google.firebase:firebase-perf-ktx"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx"
    const val firebaseFirestore = "com.google.firebase:firebase-firestore-ktx"
    const val firebaseRemoteConfig = "com.google.firebase:firebase-config-ktx"

    const val apolloRuntime = "com.apollographql.apollo:apollo-runtime:${apolloVersion}"
    const val apolloCoroutines = "com.apollographql.apollo:apollo-coroutines-support:${apolloVersion}"

    const val coil = "io.coil-kt:coil:$coilVersion"
    const val coilCompose = "io.coil-kt:coil-compose:$coilVersion"
}