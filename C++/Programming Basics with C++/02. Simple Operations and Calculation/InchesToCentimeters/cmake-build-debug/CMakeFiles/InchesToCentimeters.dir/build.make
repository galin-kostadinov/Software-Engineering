# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.14

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files\JetBrains\CLion 2019.1.4\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files\JetBrains\CLion 2019.1.4\bin\cmake\win\bin\cmake.exe" -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\05. Simple Operations and Calculation\tasks\InchesToCentimeters"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\05. Simple Operations and Calculation\tasks\InchesToCentimeters\cmake-build-debug"

# Include any dependencies generated for this target.
include CMakeFiles/InchesToCentimeters.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/InchesToCentimeters.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/InchesToCentimeters.dir/flags.make

CMakeFiles/InchesToCentimeters.dir/main.cpp.obj: CMakeFiles/InchesToCentimeters.dir/flags.make
CMakeFiles/InchesToCentimeters.dir/main.cpp.obj: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="E:\ComputerProgramming\C++\Programming Basics with C++ 062019\05. Simple Operations and Calculation\tasks\InchesToCentimeters\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/InchesToCentimeters.dir/main.cpp.obj"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\InchesToCentimeters.dir\main.cpp.obj -c "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\05. Simple Operations and Calculation\tasks\InchesToCentimeters\main.cpp"

CMakeFiles/InchesToCentimeters.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/InchesToCentimeters.dir/main.cpp.i"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\05. Simple Operations and Calculation\tasks\InchesToCentimeters\main.cpp" > CMakeFiles\InchesToCentimeters.dir\main.cpp.i

CMakeFiles/InchesToCentimeters.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/InchesToCentimeters.dir/main.cpp.s"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\05. Simple Operations and Calculation\tasks\InchesToCentimeters\main.cpp" -o CMakeFiles\InchesToCentimeters.dir\main.cpp.s

# Object files for target InchesToCentimeters
InchesToCentimeters_OBJECTS = \
"CMakeFiles/InchesToCentimeters.dir/main.cpp.obj"

# External object files for target InchesToCentimeters
InchesToCentimeters_EXTERNAL_OBJECTS =

InchesToCentimeters.exe: CMakeFiles/InchesToCentimeters.dir/main.cpp.obj
InchesToCentimeters.exe: CMakeFiles/InchesToCentimeters.dir/build.make
InchesToCentimeters.exe: CMakeFiles/InchesToCentimeters.dir/linklibs.rsp
InchesToCentimeters.exe: CMakeFiles/InchesToCentimeters.dir/objects1.rsp
InchesToCentimeters.exe: CMakeFiles/InchesToCentimeters.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="E:\ComputerProgramming\C++\Programming Basics with C++ 062019\05. Simple Operations and Calculation\tasks\InchesToCentimeters\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable InchesToCentimeters.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\InchesToCentimeters.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/InchesToCentimeters.dir/build: InchesToCentimeters.exe

.PHONY : CMakeFiles/InchesToCentimeters.dir/build

CMakeFiles/InchesToCentimeters.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\InchesToCentimeters.dir\cmake_clean.cmake
.PHONY : CMakeFiles/InchesToCentimeters.dir/clean

CMakeFiles/InchesToCentimeters.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\05. Simple Operations and Calculation\tasks\InchesToCentimeters" "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\05. Simple Operations and Calculation\tasks\InchesToCentimeters" "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\05. Simple Operations and Calculation\tasks\InchesToCentimeters\cmake-build-debug" "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\05. Simple Operations and Calculation\tasks\InchesToCentimeters\cmake-build-debug" "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\05. Simple Operations and Calculation\tasks\InchesToCentimeters\cmake-build-debug\CMakeFiles\InchesToCentimeters.dir\DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/InchesToCentimeters.dir/depend

