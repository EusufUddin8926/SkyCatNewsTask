# Sky Cat News 🐱📰

*   **Project**: Sky Cat News 🐱📰 - A Compose Multiplatform news app for Android & iOS.
*   **Core Features**: Browse articles, view featured stories, read story details.
*   **Tech Stack**:
    *   Kotlin Multiplatform & Compose Multiplatform
    *   Coroutines, Ktor, Kotlinx Serialization (assumed)
    *   MVI Architecture
    *   Gradle, CocoaPods
*   **Recommended Environment**:
    *   Kotlin: 2.2.0
    *   AGP: 8.10.1
    *   Gradle: 8.14.3
    *   JDK: 17
    *   Latest Android Studio & Xcode
    *   Latest CocoaPods
*   **Getting Started (Android)**:
    1.  Open in Android Studio, sync Gradle.
    2.  Select `composeApp` run config.
    3.  Choose device/emulator & run.
*   **Generating Android APK**:
    *   Build menu -> Build Bundle(s) / APK(s) -> Build APK(s)
    *   OR `./gradlew :composeApp:assembleRelease`
    *   Output: `composeApp/build/outputs/apk/release/`
    *   Download pre-built APKs: [Google Drive folder](https://drive.google.com/drive/folders/15Fe8u_ae4Vgu4aqleJoRRxnQ0RQZhJoA?usp=sharing)
*   **Getting Started (iOS)**:
    1.  From project root (`/Users/mdeusufuddin/Downloads/Sky Cat News`): `./gradlew :composeApp:podInstall`
    2.  Open `iosApp/iosApp.xcworkspace` in Xcode.
    3.  Select target & `iosApp` scheme, then build & run.