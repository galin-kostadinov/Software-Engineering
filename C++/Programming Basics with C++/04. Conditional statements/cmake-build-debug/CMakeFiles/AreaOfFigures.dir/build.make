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
CMAKE_SOURCE_DIR = "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\07. Conditional statements\tasks\ConditionalStatement"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\07. Conditional statements\tasks\ConditionalStatement\cmake-build-debug"

# Include any dependencies generated for this target.
include CMakeFiles/AreaOfFigures.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/AreaOfFigures.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/AreaOfFigures.dir/flags.make

CMakeFiles/AreaOfFigures.dir/simple_tasks/AreaOfFigures.cpp.obj: CMakeFiles/AreaOfFigures.dir/flags.make
CMakeFiles/AreaOfFigures.dir/simple_tasks/AreaOfFigures.cpp.obj: ../simple_tasks/AreaOfFigures.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="E:\ComputerProgramming\C++\Programming Basics with C++ 062019\07. Conditional statements\tasks\ConditionalStatement\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/AreaOfFigures.dir/simple_tasks/AreaOfFigures.cpp.obj"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\AreaOfFigures.dir\simple_tasks\AreaOfFigures.cpp.obj -c "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\07. Conditional statements\tasks\ConditionalStatement\simple_tasks\AreaOfFigures.cpp"

CMakeFiles/AreaOfFigures.dir/simple_tasks/AreaOfFigures.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/AreaOfFigures.dir/simple_tasks/AreaOfFigures.cpp.i"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\07. Conditional statements\tasks\ConditionalStatement\simple_tasks\AreaOfFigures.cpp" > CMakeFiles\AreaOfFigures.dir\simple_tasks\AreaOfFigures.cpp.i

CMakeFiles/AreaOfFigures.dir/simple_tasks/AreaOfFigures.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/AreaOfFigures.dir/simple_tasks/AreaOfFigures.cpp.s"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\07. Conditional statements\tasks\ConditionalStatement\simple_tasks\AreaOfFigures.cpp" -o CMakeFiles\AreaOfFigures.dir\simple_tasks\AreaOfFigures.cpp.s

# Object files for target AreaOfFigures
AreaOfFigures_OBJECTS = \
"CMakeFiles/AreaOfFigures.dir/simple_tasks/AreaOfFigures.cpp.obj"

# External object files for target AreaOfFigures
AreaOfFigures_EXTERNAL_OBJECTS =

AreaOfFigures.exe: CMakeFiles/AreaOfFigures.dir/simple_tasks/AreaOfFigures.cpp.obj
AreaOfFigures.exe: CMakeFiles/AreaOfFigures.dir/build.make
AreaOfFigures.exe: CMakeFiles/AreaOfFigures.dir/linklibs.rsp
AreaOfFigures.exe: CMakeFiles/AreaOfFigures.dir/objects1.rsp
AreaOfFigures.exe: CMakeFiles/AreaOfFigures.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="E:\ComputerProgramming\C++\Programming Basics with C++ 062019\07. Conditional statements\tasks\ConditionalStatement\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable AreaOfFigures.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\AreaOfFigures.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/AreaOfFigures.dir/build: AreaOfFigures.exe

.PHONY : CMakeFiles/AreaOfFigures.dir/build

CMakeFiles/AreaOfFigures.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\AreaOfFigures.dir\cmake_clean.cmake
.PHONY : CMakeFiles/AreaOfFigures.dir/clean

CMakeFiles/AreaOfFigures.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\07. Conditional statements\tasks\ConditionalStatement" "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\07. Conditional statements\tasks\ConditionalStatement" "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\07. Conditional statements\tasks\ConditionalStatement\cmake-build-debug" "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\07. Conditional statements\tasks\ConditionalStatement\cmake-build-debug" "E:\ComputerProgramming\C++\Programming Basics with C++ 062019\07. Conditional statements\tasks\ConditionalStatement\cmake-build-debug\CMakeFiles\AreaOfFigures.dir\DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/AreaOfFigures.dir/depend

