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
CMAKE_SOURCE_DIR = "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop\cmake-build-debug"

# Include any dependencies generated for this target.
include CMakeFiles/Coins.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Coins.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Coins.dir/flags.make

CMakeFiles/Coins.dir/simple-tasks/Coins.cpp.obj: CMakeFiles/Coins.dir/flags.make
CMakeFiles/Coins.dir/simple-tasks/Coins.cpp.obj: ../simple-tasks/Coins.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/Coins.dir/simple-tasks/Coins.cpp.obj"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\Coins.dir\simple-tasks\Coins.cpp.obj -c "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop\simple-tasks\Coins.cpp"

CMakeFiles/Coins.dir/simple-tasks/Coins.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Coins.dir/simple-tasks/Coins.cpp.i"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop\simple-tasks\Coins.cpp" > CMakeFiles\Coins.dir\simple-tasks\Coins.cpp.i

CMakeFiles/Coins.dir/simple-tasks/Coins.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Coins.dir/simple-tasks/Coins.cpp.s"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop\simple-tasks\Coins.cpp" -o CMakeFiles\Coins.dir\simple-tasks\Coins.cpp.s

# Object files for target Coins
Coins_OBJECTS = \
"CMakeFiles/Coins.dir/simple-tasks/Coins.cpp.obj"

# External object files for target Coins
Coins_EXTERNAL_OBJECTS =

Coins.exe: CMakeFiles/Coins.dir/simple-tasks/Coins.cpp.obj
Coins.exe: CMakeFiles/Coins.dir/build.make
Coins.exe: CMakeFiles/Coins.dir/linklibs.rsp
Coins.exe: CMakeFiles/Coins.dir/objects1.rsp
Coins.exe: CMakeFiles/Coins.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable Coins.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\Coins.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Coins.dir/build: Coins.exe

.PHONY : CMakeFiles/Coins.dir/build

CMakeFiles/Coins.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\Coins.dir\cmake_clean.cmake
.PHONY : CMakeFiles/Coins.dir/clean

CMakeFiles/Coins.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop\cmake-build-debug" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop\cmake-build-debug" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop\cmake-build-debug\CMakeFiles\Coins.dir\DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/Coins.dir/depend

