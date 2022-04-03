import configs.AppConfig
import extensions.androidTestImplementation
import extensions.implementation
import extensions.internalApi
import extensions.testImplementation
import java.util.Properties

plugins {
    id(Plugins.Android.application)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id(Plugins.hilt)
}

androidConfig(
    defaultConfig = {
        applicationId = AppConfig.appId
    },
    anyConfig = {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = Versions.Compose.compose
        }
    }
)

dependencies {
    hiltDependencies()
    composeDependencies()
    androidXDependencies()
    lifecycleDependencies()
    coroutinesCoreDependencies()
    coroutinesAndroidDependencies()

    implementation(Libraries.AndroidX.Ktx.activity)
    implementation(Libraries.timber)

    testImplementation(Libraries.Test.junit)
    androidTestImplementation(Libraries.Test.junitExt)
    androidTestImplementation(Libraries.Test.espresso)
}
