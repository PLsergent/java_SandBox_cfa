#!/usr/bin/env python3.7

import os
from pathlib import Path
from subprocess import run, Popen
from argparse import ArgumentParser


def compile(project_src, project_class):

    java_files_path = project_src / "*.java"
    cmd_compile = f"javac -d {str(project_class)} {str(java_files_path)}"
    print(cmd_compile)

    try:
        run(cmd_compile, shell=True)
    except Exception as e:
        print(f"Some issues when compiling...\n{e}")
        return False
    else:
        return True


def run_java(project_dir, project_class, main_file, args_files):
    os.chdir(project_class)

    cmd_run = f"java {project_dir.name}/{main_file.split('.')[0]} "
    for arg in args_files:
        cmd_run += f"../{os.path.basename(arg)} "
    print(cmd_run)
    
    try:
        run(cmd_run, shell=True)
    except Exception as e:
        print(f"Some issues running the code...\n{e}")


if __name__ == '__main__':
    cli = ArgumentParser()
    cli.add_argument(
      "--path",
      nargs="*"
    )

    args = cli.parse_args()

    project_dir = Path(args.path[0])
    args_files = [Path(file) for file in args.path[1:]]

    project_src = project_dir / "src" / project_dir.name
    project_class = project_dir / "class"

    if compile(project_src, project_class):
        for file in os.listdir(project_class / project_dir.name):
            if file.endswith(".class") and file.lower().find("main") != -1:
                run_java(project_dir, project_class, file, args_files)
                break