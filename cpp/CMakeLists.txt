# Copyright (c) 2023 Murex
# 
# Permission is hereby granted, free of charge, to any person obtaining a copy
# of this software and associated documentation files (the "Software"), to deal
# in the Software without restriction, including without limitation the rights
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
# copies of the Software, and to permit persons to whom the Software is
# furnished to do so, subject to the following conditions:
# 
# The above copyright notice and this permission notice shall be included in all
# copies or substantial portions of the Software.
# 
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
# SOFTWARE.

cmake_minimum_required(VERSION 3.19.3)

project(Kata-BabyStepsGolf CXX)

set(CMAKE_CXX_STANDARD 20)
if ("${CMAKE_CXX_COMPILER_ID}" MATCHES "Clang")
    set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -stdlib=libc++ -std=c++20")
endif()
enable_testing()

set_property(GLOBAL PROPERTY USE_FOLDERS ON)

set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/lib CACHE PATH "Where to place compiled static libraries.")
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/lib CACHE PATH "Where to place compiled shared libraries.")
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/bin CACHE PATH "Where to place compiled executables.")

# We use CPM for 3rd-party dependencies management
include(cmake/CPM.cmake)
include(cmake/FindGoogleTest.cmake)
# ApprovalTests (for Golden Master tests) -->
# Uncomment if the kata is using it. Remove otherwise
#include(cmake/FindApprovalTests.cmake)

add_library(Kata-BabyStepsGolf-shared SHARED)

target_compile_definitions(Kata-BabyStepsGolf-shared PRIVATE BABY_STEPS_GOLF_EXPORTS)

target_sources(Kata-BabyStepsGolf-shared
    PRIVATE
        ${CMAKE_CURRENT_SOURCE_DIR}/src/kata/baby_steps_golf/BabyStepsGolf.cpp
    PUBLIC
        ${CMAKE_CURRENT_SOURCE_DIR}/include/kata/baby_steps_golf/BabyStepsGolf.hpp
        ${CMAKE_CURRENT_SOURCE_DIR}/include/kata/baby_steps_golf/config.hpp
)

target_include_directories(Kata-BabyStepsGolf-shared
    PRIVATE
        ${CMAKE_CURRENT_SOURCE_DIR}/src
    PUBLIC
        ${CMAKE_CURRENT_SOURCE_DIR}/include
)

add_executable(Kata-BabyStepsGolf-test)

target_sources(Kata-BabyStepsGolf-test
    PRIVATE
        ${CMAKE_CURRENT_SOURCE_DIR}/test/BabyStepsGolfTest.cpp
)

target_link_libraries(Kata-BabyStepsGolf-test
    PRIVATE
        Kata-BabyStepsGolf-shared
        # Uncomment if using ApprovalTests, remove otherwise
        # ApprovalTests
        # Uncomment if using gmock, remove otherwise
        # gmock
        gtest_main)

add_test(
    NAME ctest-Kata-BabyStepsGolf
    COMMAND Kata-BabyStepsGolf-test --gtest_brief=1 --gtest_output=xml:test-results/Kata-BabyStepsGolf-test.xml
)

add_custom_target(Docs
    SOURCES
        ../README.md
        ./GETTING_STARTED.md
        ../QuickRetrospective.md)

set_property(DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR} PROPERTY VS_STARTUP_PROJECT Kata-BabyStepsGolf-test)
set_property(DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR} PROPERTY XCODE_STARTUP_PROJECT Kata-BabyStepsGolf-test)

set_property(TARGET Kata-BabyStepsGolf-shared PROPERTY FOLDER "Kata")
set_property(TARGET Kata-BabyStepsGolf-test PROPERTY FOLDER "Kata")
set_property(TARGET Docs PROPERTY FOLDER "Kata")

set_property(TARGET gtest gtest_main PROPERTY FOLDER "Third-Party/GoogleTest")
# Uncomment if using gmock, remove otherwise
# set_property(TARGET gmock gmock_main PROPERTY FOLDER "Third-Party/GoogleTest")
# Uncomment if using ApprovalTests, remove otherwise
# set_property(TARGET ApprovalTests PROPERTY FOLDER "Third-Party")

set_property(GLOBAL PROPERTY PREDEFINED_TARGETS_FOLDER "CMake Generated")
