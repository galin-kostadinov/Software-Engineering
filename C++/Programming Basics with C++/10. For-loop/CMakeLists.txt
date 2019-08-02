cmake_minimum_required(VERSION 3.14)
project(10__For_loop)

set(CMAKE_CXX_STANDARD 14)

add_executable(10__For_loop simple_tasks/CleverLily.cpp simple_tasks/LatinLetters.cpp simple_tasks/LeftAndRightSum.cpp simple_tasks/NumberSequence.cpp simple_tasks/Numbersfrom1to100.cpp simple_tasks/OddEvenSum.cpp simple_tasks/SumNumbers.cpp simple_tasks/VowelsSum.cpp)
add_executable(VowelsSum simple_tasks/VowelsSum.cpp)
add_executable(SumNumbers simple_tasks/SumNumbers.cpp)
add_executable(OddEvenSum simple_tasks/OddEvenSum.cpp)
add_executable(Numbersfrom1to100 simple_tasks/Numbersfrom1to100.cpp)
add_executable(NumberSequence simple_tasks/NumberSequence.cpp)
add_executable(LeftAndRightSum simple_tasks/LeftAndRightSum.cpp)
add_executable(LatinLetters simple_tasks/LatinLetters.cpp)
add_executable(CleverLily simple_tasks/CleverLily.cpp)