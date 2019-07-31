cmake_minimum_required(VERSION 3.14)
project(Simple_Tasks)

set(CMAKE_CXX_STANDARD 17)

add_executable(Simple_Tasks simple-tasks/OldBooks.cpp simple-tasks/ExamPreparation.cpp simple-tasks/Vacation.cpp simple-tasks/Walking.cpp simple-tasks/Coins.cpp simple-tasks/Cake.cpp)
add_executable(Cake simple-tasks/Cake.cpp)
add_executable(Coins simple-tasks/Coins.cpp)
add_executable(Walking simple-tasks/Walking.cpp)
add_executable(Vacation simple-tasks/Vacation.cpp)
add_executable(ExamPreparation simple-tasks/ExamPreparation.cpp)
add_executable(OldBooks simple-tasks/OldBooks.cpp)