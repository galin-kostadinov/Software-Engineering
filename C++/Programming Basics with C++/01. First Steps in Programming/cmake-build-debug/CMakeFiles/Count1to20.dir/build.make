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
CMAKE_SOURCE_DIR = "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\01. First Steps in Programming"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\01. First Steps in Programming\cmake-build-debug"

# Include any dependencies generated for this target.
include CMakeFiles/Count1to20.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Count1to20.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Count1to20.dir/flags.make

CMakeFiles/Count1to20.dir/simple_tasks/Count1to20.cpp.obj: CMakeFiles/Count1to20.dir/flags.make
CMakeFiles/Count1to20.dir/simple_tasks/Count1to20.cpp.obj: ../simple_tasks/Count1to20.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\01. First Steps in Programming\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/Count1to20.dir/simple_tasks/Count1to20.cpp.obj"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\Count1to20.dir\simple_tasks\Count1to20.cpp.obj -c "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\01. First Steps in Programming\simple_tasks\Count1to20.cpp"

CMakeFiles/Count1to20.dir/simple_tasks/Count1to20.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Count1to20.dir/simple_tasks/Count1to20.cpp.i"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\01. First Steps in Programming\simple_tasks\Count1to20.cpp" > CMakeFiles\Count1to20.dir\simple_tasks\Count1to20.cpp.i

CMakeFiles/Count1to20.dir/simple_tasks/Count1to20.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Count1to20.dir/simple_tasks/Count1to20.cpp.s"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\01. First Steps in Programming\simple_tasks\Count1to20.cpp" -o CMakeFiles\Count1to20.dir\simple_tasks\Count1to20.cpp.s

# Object files for target Count1to20
Count1to20_OBJECTS = \
"CMakeFiles/Count1to20.dir/simple_tasks/Count1to20.cpp.obj"

# External object files for target Count1to20
Count1to20_EXTERNAL_OBJECTS =

Count1to20.exe: CMakeFiles/Count1to20.dir/simple_tasks/Count1to20.cpp.obj
Count1to20.exe: CMakeFiles/Count1to20.dir/build.make
Count1to20.exe: CMakeFiles/Count1to20.dir/linklibs.rsp
Count1to20.exe: CMakeFiles/Count1to20.dir/objects1.rsp
Count1to20.exe: CMakeFiles/Count1to20.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\01. First Steps in Programming\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable Count1to20.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\Count1to20.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Count1to20.dir/build: Count1to20.exe

.PHONY : CMakeFiles/Count1to20.dir/build

CMakeFiles/Count1to20.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\Count1to20.dir\cmake_clean.cmake
.PHONY : CMakeFiles/Count1to20.dir/clean

CMakeFiles/Count1to20.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\01. First Steps in Programming" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\01. First Steps in Programming" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\01. First Steps in Programming\cmake-build-debug" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\01. First Steps in Programming\cmake-build-debug" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\01. First Steps in Programming\cmake-build-debug\CMakeFiles\Count1to20.dir\DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/Count1to20.dir/depend
