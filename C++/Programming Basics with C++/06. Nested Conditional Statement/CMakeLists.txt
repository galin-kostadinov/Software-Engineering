cmake_minimum_required(VERSION 3.14)
project(NestedConditionalStatement)

set(CMAKE_CXX_STANDARD 14)

add_executable(NestedConditionalStatement simple_task/PersonalTitles.cpp simple_task/SmallShop.cpp simple_task/FruitOrVegetable.cpp simple_task/InvalidNumber.cpp simple_task/FruitShop.cpp simple_task/TradeCommissions.cpp simple_task/SkiTrip.cpp)
add_executable(SkiTrip simple_task/SkiTrip.cpp)
add_executable(TradeCommissions simple_task/TradeCommissions.cpp)
add_executable(FruitShop simple_task/FruitShop.cpp)
add_executable(InvalidNumber simple_task/InvalidNumber.cpp)
add_executable(FruitOrVegetable simple_task/FruitOrVegetable.cpp)
add_executable(SmallShop simple_task/SmallShop.cpp)
add_executable(PersonalTitles simple_task/PersonalTitles.cpp)