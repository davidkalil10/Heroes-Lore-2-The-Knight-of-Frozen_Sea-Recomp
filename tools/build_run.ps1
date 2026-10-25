$env:PATH = "C:\msys64\ucrt64\bin;$env:PATH"
Set-Location (Split-Path $PSScriptRoot -Parent)
if (!(Test-Path "build\CMakeCache.txt")) { cmake -B build -G Ninja }
cmake --build build 2>&1 | Select-String -Pattern 'error|FAILED' | Select -First 20
$p = Start-Process -FilePath build\heroes_lore_2.exe -RedirectStandardOutput run.log -RedirectStandardError run.err -PassThru
Start-Sleep ([int]($args[0] -as [int] | ForEach-Object { if ($_) { $_ } else { 8 } }))
if (!$p.HasExited) { $p.Kill() }
Get-Content run.log | Select -Skip 12 -First 40
Get-Content run.err | Select -First 20
