pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MusinsaReport"
include(":app")
include(":core:model")
include(":core:domain")
include(":core:designsystem")
//include(":core:data:api")
//include(":core:data:impl")
include(":feature:home")
include(":core:data:api")
include(":core:data:impl")
