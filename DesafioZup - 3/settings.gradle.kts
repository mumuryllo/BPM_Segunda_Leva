rootProject.name = "DesafioZup"
include("src:main:test")
findProject(":src:main:test")?.name = "test"