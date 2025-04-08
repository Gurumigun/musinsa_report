# 무신사 안드로이드 앱

## 개발 환경
- Java 17
- Android Studio Ladybug | 2024.2.1
- Kotlin
- Gradle

## 빌드 요구사항
- Android SDK
- JDK 17
- Gradle
- Android Studio Ladybug | 2024.2.1

## 필수 플러그인
- Android Application Plugin
- Kotlin Android Plugin
- Kotlin JVM Plugin
- Kotlin Serialization Plugin
- Hilt Plugin
- KSP (Kotlin Symbol Processing) Plugin
- Kotlin Compose Plugin
- Android Test Plugin
- Android Library Plugin

## 저장소 설정
1. 저장소 클론
2. Android Studio Ladybug | 2024.2.1에서 프로젝트 열기
3. Gradle 파일 동기화
4. 프로젝트 빌드

## 의존성
프로젝트는 다음 주요 의존성을 사용합니다:
- Maven Central
- Google Maven Repository

## 프로젝트 구조
- app: 메인 애플리케이션 모듈
- core: 핵심 기능 및 공유 컴포넌트
- feature: 기능별 모듈
- build-logic: 커스텀 빌드 로직 및 컨벤션

## 프로젝트 빌드 방법
1. JDK 17이 설치되어 있는지 확인
2. Android Studio Ladybug | 2024.2.1에서 프로젝트 열기
3. Gradle 동기화가 완료될 때까지 대기
4. Build 메뉴 또는 Gradle 태스크를 사용하여 프로젝트 빌드

## 참고사항
- 최신 Android SDK가 설치되어 있어야 합니다
- 프로젝트는 Gradle 설정에 Kotlin DSL을 사용합니다
- 의존성 주입을 위해 Hilt를 사용합니다
- UI 개발에 Compose를 사용합니다 