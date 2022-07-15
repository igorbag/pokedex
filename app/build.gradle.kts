import configs.AppConfig
import extensions.androidTestImplementation
import extensions.implementation
import extensions.internalModule
import extensions.testImplementation

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
    internalModule(":datai:data")
    internalModule(":datai:remote")
    internalModule(":domain")

    hiltDependencies()
    composeDependencies()
    androidXDependencies()
    lifecycleDependencies()
    coroutinesCoreDependencies()
    coroutinesAndroidDependencies()

    implementation("androidx.palette:palette-ktx:1.0.0")
    implementation(Libraries.AndroidX.Ktx.activity)
    implementation(Libraries.timber)

    testImplementation(Libraries.Test.junit)
    androidTestImplementation(Libraries.Test.junitExt)
    androidTestImplementation(Libraries.Test.espresso)
}
