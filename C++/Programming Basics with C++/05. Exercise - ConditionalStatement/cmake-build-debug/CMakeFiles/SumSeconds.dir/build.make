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
include CMakeFiles/SumSeconds.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/SumSeconds.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/SumSeconds.dir/flags.make

CMakeFiles/SumSeconds.dir/simple_tasks/SumSeconds.cpp.obj: CMakeFiles/SumSeconds.dir/flags.make
CMakeFiles/SumSeconds.dir/simple_tasks/SumSeconds.cpp.obj: ../simple_tasks/SumSeconds.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/SumSeconds.dir/simple_tasks/SumSeconds.cpp.obj"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\SumSeconds.dir\simple_tasks\SumSeconds.cpp.obj -c "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\simple_tasks\SumSeconds.cpp"

CMakeFiles/SumSeconds.dir/simple_tasks/SumSeconds.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/SumSeconds.dir/simple_tasks/SumSeconds.cpp.i"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\simple_tasks\SumSeconds.cpp" > CMakeFiles\SumSeconds.dir\simple_tasks\SumSeconds.cpp.i

CMakeFiles/SumSeconds.dir/simple_tasks/SumSeconds.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/SumSeconds.dir/simple_tasks/SumSeconds.cpp.s"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\simple_tasks\SumSeconds.cpp" -o CMakeFiles\SumSeconds.dir\simple_tasks\SumSeconds.cpp.s

# Object files for target SumSeconds
SumSeconds_OBJECTS = \
"CMakeFiles/SumSeconds.dir/simple_tasks/SumSeconds.cpp.obj"

# External object files for target SumSeconds
SumSeconds_EXTERNAL_OBJECTS =

SumSeconds.exe: CMakeFiles/SumSeconds.dir/simple_tasks/SumSeconds.cpp.obj
SumSeconds.exe: CMakeFiles/SumSeconds.dir/build.make
SumSeconds.exe: CMakeFiles/SumSeconds.dir/linklibs.rsp
SumSeconds.exe: CMakeFiles/SumSeconds.dir/objects1.rsp
SumSeconds.exe: CMakeFiles/SumSeconds.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable SumSeconds.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\SumSeconds.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/SumSeconds.dir/build: SumSeconds.exe

.PHONY : CMakeFiles/SumSeconds.dir/build

CMakeFiles/SumSeconds.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\SumSeconds.dir\cmake_clean.cmake
.PHONY : CMakeFiles/SumSeconds.dir/clean

CMakeFiles/SumSeconds.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\cmake-build-debug" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\cmake-build-debug" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\cmake-build-debug\CMakeFiles\SumSeconds.dir\DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/SumSeconds.dir/depend

