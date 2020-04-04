package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.seed.xml.TicketRootSeedDto;
import softuni.exam.models.dto.seed.xml.TicketSeedDto;
import softuni.exam.models.entity.Passenger;
import softuni.exam.models.entity.Plane;
import softuni.exam.models.entity.Ticket;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TicketRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.PlaneService;
import softuni.exam.service.TicketService;
import softuni.exam.service.TownService;
import softuni.exam.util.FileIOUtil;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static softuni.exam.constant.GlobalConstants.TICKETS_SEED_PATH;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final TownService townService;
    private final PassengerService passengerService;
    private final PlaneService planeService;
    private final ModelMapper modelMapper;
    private final FileIOUtil fileIOUtil;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    private static DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, TownService townService, PassengerService passengerService,
                             PlaneService planeService, ModelMapper modelMapper, FileIOUtil fileIOUtil, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.ticketRepository = ticketRepository;
        this.townService = townService;
        this.passengerService = passengerService;
        this.planeService = planeService;
        this.modelMapper = modelMapper;
        this.fileIOUtil = fileIOUtil;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() {
        try {
            return fileIOUtil.readFileContent(TICKETS_SEED_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    @Override
    public String importTickets() {
        StringBuilder sb = new StringBuilder();

        TicketRootSeedDto ticketRootSeedDto =
                xmlParser.objectFromFile(TicketRootSeedDto.class, TICKETS_SEED_PATH);

        for (TicketSeedDto ticketSeedDto : ticketRootSeedDto.getTickets()) {
            if (!validationUtil.isValid(ticketSeedDto)) {
                sb.append("Invalid Ticket").append(System.lineSeparator());
                continue;
            }

            if (ticketRepository.findBySerialNumber(ticketSeedDto.getSerialNumber()) != null) {
                sb.append("Invalid Ticket").append(System.lineSeparator());
                continue;
            }

            Town fromTown = townService.getByName(ticketSeedDto.getFromTown().getName());

            if (fromTown == null) {
                sb.append("Invalid Ticket").append(System.lineSeparator());
                continue;
            }

            Town toTown = townService.getByName(ticketSeedDto.getToTown().getName());

            if (toTown == null) {
                sb.append("Invalid Ticket").append(System.lineSeparator());
                continue;
            }

            Passenger passenger = passengerService.getByEmail(ticketSeedDto.getPassenger().getEmail());

            if (passenger == null) {
                sb.append("Invalid Ticket").append(System.lineSeparator());
                continue;
            }

            Plane plane = planeService.getPlaneByRegisterNumber(ticketSeedDto.getPlane().getRegisterNumber());

            if (plane == null) {
                sb.append("Invalid Ticket").append(System.lineSeparator());
                continue;
            }

            Ticket ticket = this.modelMapper.map(ticketSeedDto, Ticket.class);

            ticket.setFromTown(fromTown);
            ticket.setToTown(toTown);
            ticket.setPassenger(passenger);
            ticket.setPlane(plane);

            LocalDateTime takeoff = LocalDateTime.parse(ticketSeedDto.getTakeoff(), DATE_TIME_FORMAT);
            ticket.setTakeoff(takeoff);

            ticketRepository.saveAndFlush(ticket);

            sb.append(String.format("Successfully imported Ticket %s - %s",
                    ticket.getFromTown().getName(), ticket.getToTown().getName()))
                    .append(System.lineSeparator());

        }

        return sb.toString().trim();
    }
}
