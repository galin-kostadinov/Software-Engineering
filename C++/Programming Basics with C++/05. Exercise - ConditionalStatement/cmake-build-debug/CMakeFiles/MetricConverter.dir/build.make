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
include CMakeFiles/MetricConverter.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/MetricConverter.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/MetricConverter.dir/flags.make

CMakeFiles/MetricConverter.dir/simple_tasks/MetricConverter.cpp.obj: CMakeFiles/MetricConverter.dir/flags.make
CMakeFiles/MetricConverter.dir/simple_tasks/MetricConverter.cpp.obj: ../simple_tasks/MetricConverter.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/MetricConverter.dir/simple_tasks/MetricConverter.cpp.obj"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\MetricConverter.dir\simple_tasks\MetricConverter.cpp.obj -c "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\simple_tasks\MetricConverter.cpp"

CMakeFiles/MetricConverter.dir/simple_tasks/MetricConverter.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/MetricConverter.dir/simple_tasks/MetricConverter.cpp.i"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\simple_tasks\MetricConverter.cpp" > CMakeFiles\MetricConverter.dir\simple_tasks\MetricConverter.cpp.i

CMakeFiles/MetricConverter.dir/simple_tasks/MetricConverter.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/MetricConverter.dir/simple_tasks/MetricConverter.cpp.s"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\simple_tasks\MetricConverter.cpp" -o CMakeFiles\MetricConverter.dir\simple_tasks\MetricConverter.cpp.s

# Object files for target MetricConverter
MetricConverter_OBJECTS = \
"CMakeFiles/MetricConverter.dir/simple_tasks/MetricConverter.cpp.obj"

# External object files for target MetricConverter
MetricConverter_EXTERNAL_OBJECTS =

MetricConverter.exe: CMakeFiles/MetricConverter.dir/simple_tasks/MetricConverter.cpp.obj
MetricConverter.exe: CMakeFiles/MetricConverter.dir/build.make
MetricConverter.exe: CMakeFiles/MetricConverter.dir/linklibs.rsp
MetricConverter.exe: CMakeFiles/MetricConverter.dir/objects1.rsp
MetricConverter.exe: CMakeFiles/MetricConverter.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable MetricConverter.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\MetricConverter.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/MetricConverter.dir/build: MetricConverter.exe

.PHONY : CMakeFiles/MetricConverter.dir/build

CMakeFiles/MetricConverter.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\MetricConverter.dir\cmake_clean.cmake
.PHONY : CMakeFiles/MetricConverter.dir/clean

CMakeFiles/MetricConverter.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\cmake-build-debug" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\cmake-build-debug" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\05. Exercise - ConditionalStatement\cmake-build-debug\CMakeFiles\MetricConverter.dir\DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/MetricConverter.dir/depend

