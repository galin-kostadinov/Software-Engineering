cmake_minimum_required(VERSION 3.14)
project(Simple_Tasks)

set(CMAKE_CXX_STANDARD 17)

add_executable(Simple_Tasks main.cpp Simple-Tasks/NumberInRange1to100.cpp Simple-Tasks/Sequence2k-plus-1.cpp Simple-Tasks/AccountBalance.cpp Simple-Tasks/MaxNumber.cpp Simple-Tasks/MinNumber.cpp Simple-Tasks/Graduation.cpp Simple-Tasks/GraduationPt2.cpp Simple-Tasks/Moving.cpp)
add_executable(AccountBalance Simple-Tasks/AccountBalance.cpp)
add_executable(NumberInRange1to100 Simple-Tasks/NumberInRange1to100.cpp)
add_executable(Sequence2k-plus-1 Simple-Tasks/Sequence2k-plus-1.cpp)
add_executable(Moving Simple-Tasks/Moving.cpp)
add_executable(GraduationPt2 Simple-Tasks/GraduationPt2.cpp)
add_executable(Graduation Simple-Tasks/Graduation.cpp)
add_executable(MinNumber Simple-Tasks/MinNumber.cpp)
add_executable(MaxNumber Simple-Tasks/MaxNumber.cpp)