$env:PATH = "C:\msys64\ucrt64\bin;$env:PATH"
Set-Location (Split-Path $PSScriptRoot -Parent)
cmake --build build_shot 2>&1 | Select-String -Pattern 'error' | Select -First 10
Remove-Item screenshot_frame_*.bmp -ErrorAction SilentlyContinue
$p = Start-Process build_shot\heroes_lore_2.exe -RedirectStandardOutput run3.log -RedirectStandardError run3.err -PassThru
Start-Sleep 70
if (!$p.HasExited) { $p.Kill() }
python -c "
from PIL import Image
ns=[320,400,480,560,640,800]
W=Image.new('RGB',(240*len(ns),320))
for i,n in enumerate(ns): W.paste(Image.open(f'screenshot_frame_{n}.bmp').convert('RGB'),(240*i,0))
W.save('C:/Users/david/.gemini/antigravity-ide/brain/87758c67-ed3e-440b-8d51-3a66947a6ceb/strip2.png')"
Select-String run3.log -Pattern 'Exce|FATAL|devkey' | Select -First 8 | % Line
