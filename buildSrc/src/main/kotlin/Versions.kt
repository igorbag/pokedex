object Versions {
    const val gradle = "7.0.4"

    object Kotlin {
        const val gradle = "1.5.31"
        const val coroutines = "1.6.0"
    }

    object Compose {
        const val compose = "1.0.5"

        const val ui = compose
        const val coil = "2.0.0-rc02"
        const val uiTest = compose
        const val material = compose
        const val activity = "1.4.0"
        const val uiTooling = compose
        const val toolingPreview = compose
        const val navigation = "2.4.2"
    }

    object Dagger {
        const val dagger = "2.40.5"
        const val compiler = "2.40.5"
    }

    object Hilt {
        const val hilt = "2.40.5"

        const val work = "1.0.0"
        const val android = "2.40.5"
        const val compiler = "2.40.5"
        const val hiltNavigation = "1.0.0"
    }

    object Google {
        const val material = "1.4.0"
    }

    object AndroidX {
        object Ktx {
            const val work = "2.7.1"
            const val core = "1.6.0"
            const val activity = "1.4.0"
        }

        const val appcompat = "1.3.1"
        const val palette = "1.0.0"
    }

    object Test {
        const val mockk = "1.12.0"
        const val junit = "4.13.2"
        const val runner = "1.4.0"
        const val junitExt = "1.1.3"
        const val espresso = "3.4.0"
        const val coroutines = "1.6.0"
        const val kotlinTest = "1.6.10"
    }

    object Room {
        private const val room = "2.4.2"

        const val runtime = room
        const val ktx = room
        const val compiler = room
        const val testing = room
    }

    const val lifecycle = "2.4.0"

    const val retrofit = "2.9.0"
    const val loggingInterceptor = "4.9.0"
    const val timber = "5.0.1"
    const val detekt = "1.20.0"
}
