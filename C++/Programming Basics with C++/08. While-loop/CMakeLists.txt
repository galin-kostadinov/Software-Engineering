cmake_minimum_required(VERSION 3.14)
project(08__While_loop)

set(CMAKE_CXX_STANDARD 14)

add_executable(08__While_loop simple_tasks/AccountBalance.cpp simple_tasks/Graduation.cpp simple_tasks/GraduationPt2.cpp simple_tasks/MaxNumber.cpp simple_tasks/MinNumber.cpp simple_tasks/Moving.cpp simple_tasks/NumberInRange1to100.cpp simple_tasks/Sequence2k-plus-1.cpp)
add_executable(Sequence2k-plus-1 simple_tasks/Sequence2k-plus-1.cpp)
add_executable(NumberInRange1to100 simple_tasks/NumberInRange1to100.cpp)
add_executable(Moving simple_tasks/Moving.cpp)
add_executable(MinNumber simple_tasks/MinNumber.cpp)
add_executable(MaxNumber simple_tasks/MaxNumber.cpp)
add_executable(GraduationPt2 simple_tasks/GraduationPt2.cpp)
add_executable(Graduation simple_tasks/Graduation.cpp)
add_executable(AccountBalance simple_tasks/AccountBalance.cpp)