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
CMAKE_SOURCE_DIR = "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\13. Exercise - Nested loops"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\13. Exercise - Nested loops\cmake-build-debug"

# Include any dependencies generated for this target.
include CMakeFiles/EqualSumsLeftRightPosition.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/EqualSumsLeftRightPosition.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/EqualSumsLeftRightPosition.dir/flags.make

CMakeFiles/EqualSumsLeftRightPosition.dir/simple_task/EqualSumsLeftRightPosition.cpp.obj: CMakeFiles/EqualSumsLeftRightPosition.dir/flags.make
CMakeFiles/EqualSumsLeftRightPosition.dir/simple_task/EqualSumsLeftRightPosition.cpp.obj: ../simple_task/EqualSumsLeftRightPosition.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\13. Exercise - Nested loops\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/EqualSumsLeftRightPosition.dir/simple_task/EqualSumsLeftRightPosition.cpp.obj"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\EqualSumsLeftRightPosition.dir\simple_task\EqualSumsLeftRightPosition.cpp.obj -c "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\13. Exercise - Nested loops\simple_task\EqualSumsLeftRightPosition.cpp"

CMakeFiles/EqualSumsLeftRightPosition.dir/simple_task/EqualSumsLeftRightPosition.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/EqualSumsLeftRightPosition.dir/simple_task/EqualSumsLeftRightPosition.cpp.i"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\13. Exercise - Nested loops\simple_task\EqualSumsLeftRightPosition.cpp" > CMakeFiles\EqualSumsLeftRightPosition.dir\simple_task\EqualSumsLeftRightPosition.cpp.i

CMakeFiles/EqualSumsLeftRightPosition.dir/simple_task/EqualSumsLeftRightPosition.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/EqualSumsLeftRightPosition.dir/simple_task/EqualSumsLeftRightPosition.cpp.s"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\13. Exercise - Nested loops\simple_task\EqualSumsLeftRightPosition.cpp" -o CMakeFiles\EqualSumsLeftRightPosition.dir\simple_task\EqualSumsLeftRightPosition.cpp.s

# Object files for target EqualSumsLeftRightPosition
EqualSumsLeftRightPosition_OBJECTS = \
"CMakeFiles/EqualSumsLeftRightPosition.dir/simple_task/EqualSumsLeftRightPosition.cpp.obj"

# External object files for target EqualSumsLeftRightPosition
EqualSumsLeftRightPosition_EXTERNAL_OBJECTS =

EqualSumsLeftRightPosition.exe: CMakeFiles/EqualSumsLeftRightPosition.dir/simple_task/EqualSumsLeftRightPosition.cpp.obj
EqualSumsLeftRightPosition.exe: CMakeFiles/EqualSumsLeftRightPosition.dir/build.make
EqualSumsLeftRightPosition.exe: CMakeFiles/EqualSumsLeftRightPosition.dir/linklibs.rsp
EqualSumsLeftRightPosition.exe: CMakeFiles/EqualSumsLeftRightPosition.dir/objects1.rsp
EqualSumsLeftRightPosition.exe: CMakeFiles/EqualSumsLeftRightPosition.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\13. Exercise - Nested loops\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable EqualSumsLeftRightPosition.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\EqualSumsLeftRightPosition.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/EqualSumsLeftRightPosition.dir/build: EqualSumsLeftRightPosition.exe

.PHONY : CMakeFiles/EqualSumsLeftRightPosition.dir/build

CMakeFiles/EqualSumsLeftRightPosition.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\EqualSumsLeftRightPosition.dir\cmake_clean.cmake
.PHONY : CMakeFiles/EqualSumsLeftRightPosition.dir/clean

CMakeFiles/EqualSumsLeftRightPosition.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\13. Exercise - Nested loops" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\13. Exercise - Nested loops" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\13. Exercise - Nested loops\cmake-build-debug" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\13. Exercise - Nested loops\cmake-build-debug" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\13. Exercise - Nested loops\cmake-build-debug\CMakeFiles\EqualSumsLeftRightPosition.dir\DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/EqualSumsLeftRightPosition.dir/depend

