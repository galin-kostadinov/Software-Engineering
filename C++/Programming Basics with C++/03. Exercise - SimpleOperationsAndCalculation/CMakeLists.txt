cmake_minimum_required(VERSION 3.14)
project(tasks)

set(CMAKE_CXX_STANDARD 14)

add_executable(tasks main.cpp simple_tasks/convertorUSDtoBGN.cpp)
add_executable(convertorUSDtoBGN simple_tasks/convertorUSDtoBGN.cpp simple_tasks/RadiansToDegrees.cpp simple_tasks/rectangleArea.cpp simple_tasks/tailoringWorkshop.cpp simple_tasks/danceHall.cpp simple_tasks/charityCampaign.cpp simple_tasks/alcoholMarket.cpp simple_tasks/rectangleAreaSecond.cpp)
add_executable(tailoringWorkshop simple_tasks/tailoringWorkshop.cpp)
add_executable(rectangleArea simple_tasks/rectangleArea.cpp)
add_executable(RadiansToDegrees simple_tasks/RadiansToDegrees.cpp)
add_executable(danceHall simple_tasks/danceHall.cpp)
add_executable(charityCampaign simple_tasks/charityCampaign.cpp)
add_executable(alcoholMarket simple_tasks/alcoholMarket.cpp)
add_executable(rectangleAreaSecond simple_tasks/rectangleAreaSecond.cpp)