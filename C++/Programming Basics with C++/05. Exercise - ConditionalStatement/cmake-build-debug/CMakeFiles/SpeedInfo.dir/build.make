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
CMAKE_SOURCE_DIR = "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\cmake-build-debug"

# Include any dependencies generated for this target.
include CMakeFiles/SpeedInfo.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/SpeedInfo.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/SpeedInfo.dir/flags.make

CMakeFiles/SpeedInfo.dir/simple_tasks/SpeedInfo.cpp.obj: CMakeFiles/SpeedInfo.dir/flags.make
CMakeFiles/SpeedInfo.dir/simple_tasks/SpeedInfo.cpp.obj: ../simple_tasks/SpeedInfo.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/SpeedInfo.dir/simple_tasks/SpeedInfo.cpp.obj"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\SpeedInfo.dir\simple_tasks\SpeedInfo.cpp.obj -c "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\simple_tasks\SpeedInfo.cpp"

CMakeFiles/SpeedInfo.dir/simple_tasks/SpeedInfo.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/SpeedInfo.dir/simple_tasks/SpeedInfo.cpp.i"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\simple_tasks\SpeedInfo.cpp" > CMakeFiles\SpeedInfo.dir\simple_tasks\SpeedInfo.cpp.i

CMakeFiles/SpeedInfo.dir/simple_tasks/SpeedInfo.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/SpeedInfo.dir/simple_tasks/SpeedInfo.cpp.s"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\simple_tasks\SpeedInfo.cpp" -o CMakeFiles\SpeedInfo.dir\simple_tasks\SpeedInfo.cpp.s

# Object files for target SpeedInfo
SpeedInfo_OBJECTS = \
"CMakeFiles/SpeedInfo.dir/simple_tasks/SpeedInfo.cpp.obj"

# External object files for target SpeedInfo
SpeedInfo_EXTERNAL_OBJECTS =

SpeedInfo.exe: CMakeFiles/SpeedInfo.dir/simple_tasks/SpeedInfo.cpp.obj
SpeedInfo.exe: CMakeFiles/SpeedInfo.dir/build.make
SpeedInfo.exe: CMakeFiles/SpeedInfo.dir/linklibs.rsp
SpeedInfo.exe: CMakeFiles/SpeedInfo.dir/objects1.rsp
SpeedInfo.exe: CMakeFiles/SpeedInfo.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable SpeedInfo.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\SpeedInfo.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/SpeedInfo.dir/build: SpeedInfo.exe

.PHONY : CMakeFiles/SpeedInfo.dir/build

CMakeFiles/SpeedInfo.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\SpeedInfo.dir\cmake_clean.cmake
.PHONY : CMakeFiles/SpeedInfo.dir/clean

CMakeFiles/SpeedInfo.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\cmake-build-debug" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\cmake-build-debug" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\cmake-build-debug\CMakeFiles\SpeedInfo.dir\DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/SpeedInfo.dir/depend

