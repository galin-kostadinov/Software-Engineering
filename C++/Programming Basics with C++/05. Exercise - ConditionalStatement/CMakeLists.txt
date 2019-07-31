cmake_minimum_required(VERSION 3.14)
project(ConditionalStatementEx)

set(CMAKE_CXX_STANDARD 14)

add_executable(ConditionalStatementEx simple_tasks/SumSeconds.cpp simple_tasks/BonusScore.cpp simple_tasks/SpeedInfo.cpp simple_tasks/MetricConverter.cpp simple_tasks/TimePlus15Minutes.cpp simple_tasks/GodzillaVsKong.cpp simple_tasks/WorldSwimmingRecord.cpp simple_tasks/Scholarship.cpp)
add_executable(SumSeconds simple_tasks/SumSeconds.cpp)
add_executable(BonusScore simple_tasks/BonusScore.cpp)
add_executable(GodzillaVsKong simple_tasks/GodzillaVsKong.cpp)
add_executable(MetricConverter simple_tasks/MetricConverter.cpp)
add_executable(Scholarship simple_tasks/Scholarship.cpp)
add_executable(SpeedInfo simple_tasks/SpeedInfo.cpp)
add_executable(TimePlus15Minutes simple_tasks/TimePlus15Minutes.cpp)
add_executable(WorldSwimmingRecord simple_tasks/WorldSwimmingRecord.cpp)