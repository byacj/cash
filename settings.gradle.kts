rootProject.name = "cash-friends"

include(
    "cash",
    "friends",
    "scheduler",
)

project(":cash").projectDir = file("app/cash")
project(":friends").projectDir = file("app/friends")
project(":scheduler").projectDir = file("app/scheduler")