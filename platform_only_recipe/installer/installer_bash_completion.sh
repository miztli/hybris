#!/bin/sh

# This is installer bash completion script for unix operation systems running bash as a shell
# Copy this file to your home bin directory and add following snippet to your .profile
#
# if [ -f ~/bin/installer_bash_completion.sh ]; then
#  . ~/bin/installer_bash_completion.sh
# fi
#
# save the file and restart console or run command:
#
# source ~/.profile
#

list_contains() {
  local tgt="$1"; shift
  while (( $# )); do
    if [[ $1 = "$tgt" ]] ; then
      return 0
    fi
    shift
  done
  return 1
}

parse_options()
{
    if [ -d "./recipes" ] ; then
      local cur prev additional_opts main_tasks recipe_names
      COMPREPLY=()
      cur="${COMP_WORDS[COMP_CWORD]}"
      prev="${COMP_WORDS[COMP_CWORD-1]}"
      main_opts="-h -r -t"
      additional_opts="--stacktrace --info --debug -P"
      main_tasks="setup build initialize initializeJunit start startInBackground stopInBackground testJunit testInitialize testServer createImagesStructure perform performTestJunit performTestInitialize performTestServer"
      recipe_names=$(for x in recipes/*/; do basename "${x}" ; done )

      if [ "${prev}" = "-h" ] || [ "${prev}" = "--help" ]; then
        return 0
      fi

      if [ "${prev}" = "-r" ] || [ "${prev}" = "--recipe" ] || [ "${prev}" = "-t" ] || [ "${prev}" = "--tasks" ]; then
        COMPREPLY=( $(compgen -W "${recipe_names}" -- ${cur}) )
        return 0
      fi

      if list_contains ${prev} ${recipe_names}; then
        local switch=${COMP_WORDS[COMP_CWORD-2]}

        if [ ${switch} = '-t' ]; then
          COMPREPLY=( $(compgen -W "${additional_opts}" -- ${cur}) )
          return 0
        else
          COMPREPLY=( $(compgen -W "${main_tasks}" -- ${cur}) )
          return 0
        fi
      fi

      if list_contains ${prev} $( compgen -W "${main_tasks}" ); then
        COMPREPLY=( $(compgen -W "${additional_opts}" -- ${cur}) )
        return 0
      fi

      if list_contains ${prev} $( compgen -W "${additional_opts}" ); then
        COMPREPLY=( $(compgen -W "${additional_opts}" -- ${cur}) )
        return 0
      fi

      COMPREPLY=($(compgen -W "${main_opts}" -- ${cur}))

      return 0
  else
    echo "You must be inside of installer directory to run this command"
    return 1
  fi
}
complete -F parse_options install.sh
