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
CMAKE_SOURCE_DIR = "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\10. For-loop"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\10. For-loop\cmake-build-debug"

# Include any dependencies generated for this target.
include CMakeFiles/SumNumbers.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/SumNumbers.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/SumNumbers.dir/flags.make

CMakeFiles/SumNumbers.dir/simple_tasks/SumNumbers.cpp.obj: CMakeFiles/SumNumbers.dir/flags.make
CMakeFiles/SumNumbers.dir/simple_tasks/SumNumbers.cpp.obj: ../simple_tasks/SumNumbers.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\10. For-loop\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/SumNumbers.dir/simple_tasks/SumNumbers.cpp.obj"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\SumNumbers.dir\simple_tasks\SumNumbers.cpp.obj -c "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\10. For-loop\simple_tasks\SumNumbers.cpp"

CMakeFiles/SumNumbers.dir/simple_tasks/SumNumbers.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/SumNumbers.dir/simple_tasks/SumNumbers.cpp.i"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\10. For-loop\simple_tasks\SumNumbers.cpp" > CMakeFiles\SumNumbers.dir\simple_tasks\SumNumbers.cpp.i

CMakeFiles/SumNumbers.dir/simple_tasks/SumNumbers.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/SumNumbers.dir/simple_tasks/SumNumbers.cpp.s"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\10. For-loop\simple_tasks\SumNumbers.cpp" -o CMakeFiles\SumNumbers.dir\simple_tasks\SumNumbers.cpp.s

# Object files for target SumNumbers
SumNumbers_OBJECTS = \
"CMakeFiles/SumNumbers.dir/simple_tasks/SumNumbers.cpp.obj"

# External object files for target SumNumbers
SumNumbers_EXTERNAL_OBJECTS =

SumNumbers.exe: CMakeFiles/SumNumbers.dir/simple_tasks/SumNumbers.cpp.obj
SumNumbers.exe: CMakeFiles/SumNumbers.dir/build.make
SumNumbers.exe: CMakeFiles/SumNumbers.dir/linklibs.rsp
SumNumbers.exe: CMakeFiles/SumNumbers.dir/objects1.rsp
SumNumbers.exe: CMakeFiles/SumNumbers.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\10. For-loop\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable SumNumbers.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\SumNumbers.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/SumNumbers.dir/build: SumNumbers.exe

.PHONY : CMakeFiles/SumNumbers.dir/build

CMakeFiles/SumNumbers.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\SumNumbers.dir\cmake_clean.cmake
.PHONY : CMakeFiles/SumNumbers.dir/clean

CMakeFiles/SumNumbers.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\10. For-loop" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\10. For-loop" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\10. For-loop\cmake-build-debug" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\10. For-loop\cmake-build-debug" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\10. For-loop\cmake-build-debug\CMakeFiles\SumNumbers.dir\DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/SumNumbers.dir/depend

