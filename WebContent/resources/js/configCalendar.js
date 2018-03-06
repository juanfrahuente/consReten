//Define calendar(s): addCalendar ("Unique Calendar Name", "Window title", "Form element's name", Form name")
addCalendar("Calendar1", "Fecha de Inicio", "{pageFlow.filtro.fechaIni}", "beginForm");
addCalendar("Calendar2", "Fecha de Termino", "{pageFlow.filtro.fechaFin}", "beginForm");
addCalendar("Calendar3", "Fecha de Termino", "{pageFlow.filtro.fechVencDesde}", "beginForm");
addCalendar("Calendar4", "Fecha de Termino", "{pageFlow.filtro.fechVencHasta}", "beginForm");

// default settings for English
// Uncomment desired lines and modify its values
// setFont("verdana", 9);
setWidth(90, 1, 15, 1);
// setColor("#cccccc", "#cccccc", "#ffffff", "#ffffff", "#333333", "#cccccc", "#333333");
// setFontColor("#333333", "#333333", "#333333", "#ffffff", "#333333");
setFormat("dd/mm/yyyy");
// setSize(200, 200, -200, 16);

// setWeekDay(0);
setMonthNames("Enero","Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
//SetDayNames("Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado");
//setLinkNames('[Cerrar]','[Limpiar]');