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
include CMakeFiles/Cake.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Cake.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Cake.dir/flags.make

CMakeFiles/Cake.dir/simple-tasks/Cake.cpp.obj: CMakeFiles/Cake.dir/flags.make
CMakeFiles/Cake.dir/simple-tasks/Cake.cpp.obj: ../simple-tasks/Cake.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/Cake.dir/simple-tasks/Cake.cpp.obj"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\Cake.dir\simple-tasks\Cake.cpp.obj -c "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop\simple-tasks\Cake.cpp"

CMakeFiles/Cake.dir/simple-tasks/Cake.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Cake.dir/simple-tasks/Cake.cpp.i"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop\simple-tasks\Cake.cpp" > CMakeFiles\Cake.dir\simple-tasks\Cake.cpp.i

CMakeFiles/Cake.dir/simple-tasks/Cake.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Cake.dir/simple-tasks/Cake.cpp.s"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop\simple-tasks\Cake.cpp" -o CMakeFiles\Cake.dir\simple-tasks\Cake.cpp.s

# Object files for target Cake
Cake_OBJECTS = \
"CMakeFiles/Cake.dir/simple-tasks/Cake.cpp.obj"

# External object files for target Cake
Cake_EXTERNAL_OBJECTS =

Cake.exe: CMakeFiles/Cake.dir/simple-tasks/Cake.cpp.obj
Cake.exe: CMakeFiles/Cake.dir/build.make
Cake.exe: CMakeFiles/Cake.dir/linklibs.rsp
Cake.exe: CMakeFiles/Cake.dir/objects1.rsp
Cake.exe: CMakeFiles/Cake.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable Cake.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\Cake.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Cake.dir/build: Cake.exe

.PHONY : CMakeFiles/Cake.dir/build

CMakeFiles/Cake.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\Cake.dir\cmake_clean.cmake
.PHONY : CMakeFiles/Cake.dir/clean

CMakeFiles/Cake.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop\cmake-build-debug" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop\cmake-build-debug" "E:\ComputerProgramming\GitHubRepoSoftUniTasks\Software-Engineering\C++\Programming Basics with C++\09. Exercise - While-loop\cmake-build-debug\CMakeFiles\Cake.dir\DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/Cake.dir/depend

